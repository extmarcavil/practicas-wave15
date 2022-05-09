package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserFollowedDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.*;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IUserService;
import com.be.java.hisp.w156.be.java.hisp.w156.utils.JsonAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.UserFactory.getUserDTOS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class UserControllerTest {

    private static final String API_PATH = "/users";
    private static final String FOLLOW_USER = API_PATH+"/{userId}/follow/{userIdToFollow}";
    private static final String UNFOLLOW_USER = API_PATH+"/{userId}/unfollow/{userIdToFollow}";
    private static final String FOLLOWERS_COUNT = API_PATH+"/{userId}/followers/count";
    private static final String FOLLOWERS_LIST = API_PATH+"/{userId}/followers/list";
    private static final String FOLLOWED_LIST = API_PATH+"/{userId}/followed/list";

    private static final Integer USER_ID = 1;
    private static final Integer USER_ID_TO_FOLLOW = 2;

    @Autowired
    private JsonAdapter mapper;

    @InjectMocks
    private UserController controller;

    @Mock
    private IUserService userService;

    private MockMvc mockApiRest;

    @BeforeEach
    void setUp() {
        mockApiRest = generateMockApiRest();
    }

    @Test
    void whenTheUserToFollowDoesNotExist_thenAnExceptionIsThrown() throws Exception {
        when(userService.follow(USER_ID, USER_ID_TO_FOLLOW)).thenThrow(new UserNotFoundException(USER_ID_TO_FOLLOW));

        makeARequestPostAndAssertItFailedFrom(post(FOLLOW_USER, USER_ID, USER_ID_TO_FOLLOW))
                .andExpect(status().isNotFound())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        NOT_FOUND,
                        UserNotFoundException.class,
                        "El usuario con ID: "+USER_ID_TO_FOLLOW+" no fue encontrado"));
    }

    @Test
    void whenTheUserToFollowExists_thenAnSuccessDtoIsReturnedAndStatus200() throws Exception {
        String messageExpected = String.format("The id user: %s had follow user %s", USER_ID, USER_ID_TO_FOLLOW);

        when(userService.follow(USER_ID, USER_ID_TO_FOLLOW))
                .thenReturn(new ResponseEntity<>(new SuccessDTO(messageExpected), HttpStatus.OK));

        String response = mockApiRest.perform(post(FOLLOW_USER, USER_ID, USER_ID_TO_FOLLOW)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(response).contains(messageExpected);
    }

    @Test
    void whenTheUserToUnfollowDoesNotExist_thenAnExceptionIsThrown() throws Exception {
        when(userService.unfollow(USER_ID, USER_ID_TO_FOLLOW)).thenThrow(new UserNotFoundException(USER_ID_TO_FOLLOW));

        makeARequestPostAndAssertItFailedFrom(post(UNFOLLOW_USER, USER_ID, USER_ID_TO_FOLLOW))
                .andExpect(status().isNotFound())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        NOT_FOUND,
                        UserNotFoundException.class,
                        "El usuario con ID: "+USER_ID_TO_FOLLOW+" no fue encontrado"));
    }

    @Test
    void whenTheUserToUnFollowExists_thenStatus200IsReturned() throws Exception {
        String messageExpected = String.format("The id user: %s had unfollow user %s", USER_ID, USER_ID_TO_FOLLOW);

        when(userService.unfollow(USER_ID, USER_ID_TO_FOLLOW))
                .thenReturn(new ResponseEntity<>(new SuccessDTO(messageExpected), HttpStatus.OK));

        mockApiRest.perform(post(UNFOLLOW_USER, USER_ID, USER_ID_TO_FOLLOW)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, atLeastOnce()).unfollow(USER_ID, USER_ID_TO_FOLLOW);
    }

    @Test
    void whenTheUserWantsToFollowHimself_theAnExceptionIsThrown() throws Exception {
        when(userService.follow(USER_ID, USER_ID)).thenThrow(new UserCantFollowHimselfException());

        makeARequestPostAndAssertItFailedFrom(post(FOLLOW_USER, USER_ID, USER_ID))
                .andExpect(status().isBadRequest())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        BAD_REQUEST,
                        UserCantFollowHimselfException.class,
                        "El usuario no puede seguirse a si mismo.")
                );
    }

    @Test
    void whenTheUserAlreadyFollowsTheUserToFollow_theAnExceptionIsThrown() throws Exception {
        when(userService.follow(USER_ID, USER_ID_TO_FOLLOW))
                .thenThrow(new UserAlreadyFollowsTheUserException(USER_ID, USER_ID_TO_FOLLOW));

        makeARequestPostAndAssertItFailedFrom(post(FOLLOW_USER, USER_ID, USER_ID_TO_FOLLOW))
                .andExpect(status().isBadRequest())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        BAD_REQUEST,
                        UserAlreadyFollowsTheUserException.class,
                        String.format("El usuario %s ya sigue al usuario %s", USER_ID, USER_ID_TO_FOLLOW)));
    }

    private ResultActions makeARequestPostAndAssertItFailedFrom(MockHttpServletRequestBuilder FOLLOW_USER) throws Exception {
        return mockApiRest.perform(FOLLOW_USER.contentType(APPLICATION_JSON));
    }

    @Test
    void whenTheUserHasFollows_thenTheQuantityAndStatusOkAreReturned() {
        ResponseEntity<UserCountFollowersDTO> responseEntity =
                new ResponseEntity<>(new UserCountFollowersDTO(USER_ID, "PEPE", 5), OK);

        when(userService.getCountFollowers(USER_ID)).thenReturn(responseEntity);

        String response = makeARequestAndGetAResponseFrom(FOLLOWERS_COUNT);

        UserCountFollowersDTO userCountFollowersDTO = mapper.fromJson(response, UserCountFollowersDTO.class);

        assertThat(userCountFollowersDTO).usingRecursiveComparison().isEqualTo(responseEntity.getBody());
    }

    @Test
    void whenTheUserHasFollowers_thenTheFollowersAsListAndStatusOkAreReturned() {
        ResponseEntity<UserFollowersDTO> responseEntity =
                new ResponseEntity<>(new UserFollowersDTO(USER_ID, "PEPE", getUserDTOS()), OK);

        when(userService.getFollowers(eq(USER_ID), anyString())).thenReturn(responseEntity);

        String response = makeARequestAndGetAResponseFrom(FOLLOWERS_LIST);

        UserFollowersDTO userFollowersDTO = mapper.fromJson(response, UserFollowersDTO.class);

        assertThat(userFollowersDTO).usingRecursiveComparison().isEqualTo(responseEntity.getBody());
    }

    @Test
    void whenTheUserHasFollowed_thenTheFollowedAsListAndStatusOkAreReturned() {
        ResponseEntity<UserFollowedDTO> responseEntity =
                new ResponseEntity<>(new UserFollowedDTO(USER_ID, "PEPE", getUserDTOS()), OK);

        when(userService.getFollowed(eq(USER_ID), anyString())).thenReturn(responseEntity);

        String response = makeARequestAndGetAResponseFrom(FOLLOWED_LIST);

        UserFollowedDTO userFollowedDTO = mapper.fromJson(response, UserFollowedDTO.class);

        assertThat(userFollowedDTO).usingRecursiveComparison().isEqualTo(responseEntity.getBody());
    }

    private String makeARequestAndGetAResponseFrom(String followedList) {
        try {
            return makeARequestPostAndAssertItFailedFrom(get(followedList, USER_ID))
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception ignore) {
            return null;
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"date_asc2", "asdsadsa", "11", "-$#"})
    void whenTheRequestParamForFollowersIsInvalid_thenAnExceptionIsThrown(String requestParamInvalid) throws Exception {
        when(userService.getFollowers(any(), eq(requestParamInvalid))).thenThrow(new InvalidOrderException());

        mockApiRest.perform(get(FOLLOWERS_LIST, USER_ID)
                        .param("order", requestParamInvalid)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(error -> assertExceptionWithStatusAndErrorMessage(error,
                        NOT_FOUND,
                        InvalidOrderException.class,
                        "El tipo de ordenamiento no es valido.")
                );

    }

    private void assertExceptionWithStatusAndErrorMessage(MvcResult error, HttpStatus status,
                                                          Class<? extends RuntimeException> exceptionExpected,
                                                          String messageExpected) {
        Exception resolvedException = error.getResolvedException();

        assertAll(
                () -> assertThat(error.getResponse().getStatus()).isEqualTo(status.value()),
                () -> assertThat(resolvedException).isInstanceOf(exceptionExpected),
                () ->  assertThat(resolvedException).hasMessage(messageExpected)
        );
    }

    private MockMvc generateMockApiRest() {
        return standaloneSetup(controller)
                .setControllerAdvice(new ControllerAdviceExceptions())
                .build();
    }
}