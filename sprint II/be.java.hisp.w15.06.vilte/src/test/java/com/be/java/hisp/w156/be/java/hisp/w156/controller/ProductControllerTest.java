package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.ControllerAdviceExceptions;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.InvalidOrderException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IProductService;
import com.be.java.hisp.w156.be.java.hisp.w156.utils.JsonAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.stream.Stream;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.RequestPostDtoFactory.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class ProductControllerTest {

    private static final String API_PATH = "/products";
    private static final String CREATE_POST = String.format(API_PATH+"/%s", "post");
    private static final String GET_FOLLOWED = String.format("%s/followed/{userId}/list", API_PATH);

    @Autowired
    private JsonAdapter mapper;

    @InjectMocks
    private ProductController controller;

    @Mock
    private IProductService productService;

    private MockMvc mockApiRest;
    private RequestPostDTO requestPostDTO;

    @BeforeEach
    void setUp() {
        requestPostDTO = validRequestPostDTO();
        mockApiRest = generateMockApiRest();
    }

    @Test
    void whenTheRequestPostIsValidAndTheUserExists_thenItsSavedAndResponseEntityIs200() throws Exception {
        String expectedMessage = String.format("Post with ID: %s was saved successfully", requestPostDTO.getUser_id());
        ResponseEntity<SuccessDTO> successDTOResponseEntity = createResponseEntityWithMessage(expectedMessage);

        when(productService.savePost(refEq(requestPostDTO))).thenReturn(successDTOResponseEntity);

        String response = makeRequestPost(mapper.toJson(requestPostDTO))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        assertThat(response).contains(expectedMessage);

        verify(productService, atLeastOnce()).savePost(refEq(requestPostDTO));
    }

    @Test
    void whenTheRequestPostIsValidButTheUserDoesNotExist_thenAnExceptionIsThrown() throws Exception {
        Integer userId = requestPostDTO.getUser_id();
        when(productService.savePost(refEq(requestPostDTO))).thenThrow(new UserNotFoundException(userId));

        makeRequestPost(mapper.toJson(requestPostDTO))
                .andExpect(status().isNotFound())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        NOT_FOUND,
                        UserNotFoundException.class,
                        String.format("El usuario con ID: %s no fue encontrado", userId)
                ));
    }

    @Test
    void whenTheRequestBodyIsEmpty_thenAnExceptionIsThrownAndStatusCode400() throws Exception {
        makeRequestPost("")
                .andExpect(status().isBadRequest())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        BAD_REQUEST,
                        HttpMessageNotReadableException.class,
                        "Required request body is missing")
                );
    }

    @ParameterizedTest
    @MethodSource("invalidRequestBody")
    void whenTheRequestBodyAreInvalid_thenAnExceptionIsThrown(RequestPostDTO requestPost, String errorMessage) {

        makeARequestPostAndAssertItFailed(requestPost, errorMessage);
    }

    private static Stream<Arguments> invalidRequestBody() {
        return Stream.of(
                Arguments.of(aRequestPostWithNegativeId(), "El id debe ser mayor a cero."),
                Arguments.of(aRequestPostWithIdNull(), "El id no puede estar vacío."),
                Arguments.of(aRequestPostWithDateNull(), "La fecha no puede estar vacía."),
                Arguments.of(aRequestPostWithPreviousDate(), "La fecha no puede ser anterior a hoy."),
                Arguments.of(aRequestPostWithCategoryEmpty(), "El campo no puede estar vacío."),
                Arguments.of(aRequestPostWithPriceNull(), "El campo no puede estar vacío."),
                Arguments.of(aRequestPostWithPriceGreaterThan10000000(), "El precio máximo por producto es de 10.000.00")
        );
    }

    @Test
    void whenTheRequestBodyHasAInvalidDateFormat_thenAnExceptionIsThrown() throws Exception {
        makeRequestPost(aRequestPostWithInvalidDateFormat())
                .andExpect(status().isBadRequest())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        BAD_REQUEST,
                        HttpMessageNotReadableException.class,
                        "Cannot deserialize value of type")
                );
    }

    @Test
    void whenTheRequestBodyHasNullDetail_thenAnExceptionIsThrown() {

        makeARequestPostAndAssertItFailed(aRequestPostWithDetailNull(), "must not be null");
    }

    @ParameterizedTest
    @MethodSource("detailWithInvalidFields")
    void whenTheRequestBodyIsCorrectButDetailHasFieldInvalid_thenAnExceptionIsThrown(RequestPostDTO requestPost,
                                                                                     String errorMessage) {
        makeARequestPostAndAssertItFailed(requestPost, errorMessage);
    }

    private static Stream<Arguments> detailWithInvalidFields() {
        return Stream.of(
                Arguments.of(aRequestPostWithIdDetailNull(), "El id no puede estar vacía."),
                Arguments.of(aRequestPostWithIdDetailNegative(), "El id debe ser mayor a cero."),
                Arguments.of(aRequestPostWithDetailNameEmpty(), "El campo no puede estar vacío."),
                Arguments.of(aRequestPostWithDetailNameMoreThan40Characters(),
                        "La longitud no puede superar los 40 caracteres."),
                Arguments.of(aRequestPostWithDetailNameWithSpecialCharacters(),
                        "El campo no puede poseer caracteres especiales."),
                Arguments.of(aRequestPostWithDetailTypeEmpty(), "El campo no puede estar vacío."),
                Arguments.of(aRequestPostWithDetailTypeWithSpecialCharacters(),
                        "El campo no puede poseer caracteres especiales."),
                Arguments.of(aRequestPostWithDetailBrandEmpty(), "El campo no puede estar vacío."),
                Arguments.of(aRequestPostWithDetailBrandMoreThan25Characters(),
                        "La longitud no puede superar los 25 caracteres."),
                Arguments.of(aRequestPostWithDetailBrandWithSpecialCharacters(),
                        "El campo no puede poseer caracteres especiales."),
                Arguments.of(aRequestPostWithDetailColorEmpty(), "El campo no puede estar vacío."),
                Arguments.of(aRequestPostWithDetailColorMoreThan15Characters(),
                        "La longitud no puede superar los 15 caracteres."),
                Arguments.of(aRequestPostWithDetailColorWithSpecialCharacters(),
                        "El campo no puede poseer caracteres especiales."),
                Arguments.of(aRequestPostWithDetailNotesMoreThan80Characters(),
                        "La longitud no puede superar los 80 caracteres."),
                Arguments.of(aRequestPostWithDetailNotesWithSpecialCharacters(),
                        "El campo no puede poseer caracteres especiales.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"date_asc2", "asdsadsa", "11", "-$#"})
    void whenTheRequestParamForFollowedIsInvalid_thenAnExceptionIsThrown(String requestParamInvalid) throws Exception {
        when(productService.getPostsLastTwoWeekById(any(), eq(requestParamInvalid)))
                .thenThrow(new InvalidOrderException());

        mockApiRest.perform(get(GET_FOLLOWED, String.valueOf(requestPostDTO.getUser_id()))
                        .param("order", requestParamInvalid)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        NOT_FOUND,
                        InvalidOrderException.class,
                        "El tipo de ordenamiento no es valido.")
                );

    }

    private void makeARequestPostAndAssertItFailed(RequestPostDTO requestPost, String errorMessage) {
        try {
            makeRequestPost(mapper.toJson(requestPost))
                    .andExpect(status().isBadRequest())
                    .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                            BAD_REQUEST,
                            MethodArgumentNotValidException.class,
                            errorMessage));
        } catch (Exception ignore) { }

        verify(productService, never()).savePost(requestPostDTO);
    }

    private ResultActions makeRequestPost(String content) throws Exception {
        return mockApiRest.perform(post(CREATE_POST)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content));
    }

    private ResponseEntity<SuccessDTO> createResponseEntityWithMessage(String expectedMessage) {
        return new ResponseEntity<>(new SuccessDTO(expectedMessage), HttpStatus.CREATED);
    }

    private void assertExceptionWithStatusAndErrorMessage(MvcResult error, HttpStatus status,
                                                          Class<? extends Exception> exceptionExpected,
                                                          String messageExpected) {
        Exception resolvedException = error.getResolvedException();

        assertAll(
                () -> assertThat(error.getResponse().getStatus()).isEqualTo(status.value()),
                () -> assertThat(resolvedException).isInstanceOf(exceptionExpected),
                () ->  assertThat(resolvedException).hasMessageContaining(messageExpected)
        );
    }

    private MockMvc generateMockApiRest() {
        return standaloneSetup(controller)
                .setControllerAdvice(new ControllerAdviceExceptions())
                .build();
    }

}