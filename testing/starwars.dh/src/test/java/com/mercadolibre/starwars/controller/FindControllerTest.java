package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static fixture.CharacterFixture.aCharacterDTO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class FindControllerTest {

    private final static String PATH_FIND_CHARACTERS = "/{query}";
    private final static String QUERY = "luke";

    @InjectMocks
    private FindController controller;

    @Mock
    private FindService service;

    private MockMvc mockApiRest;
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mockApiRest = standaloneSetup(controller)
                .setControllerAdvice()
                .build();
        mapper = new ObjectMapper();
    }

    @Test
    void whenTheQueryMatched_thenTheListIsReturned() {
        when(service.find(anyString())).thenReturn(List.of(aCharacterDTO()));
        List<CharacterDTO> characters = controller.find(QUERY);

        assertThat(characters.size()).isOne();
        verify(service, atLeastOnce()).find(QUERY);
    }

    @Test
    void whenThePathVariableIsEmpty_thenTheResourceIsNotFoundAndStatus404() throws Exception {
        mockApiRest.perform(get(PATH_FIND_CHARACTERS, "")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenThePathVariableIsGivenButThereIsNoMatch_thenTheResponseIsEmptyAndStatus200() throws Exception {
        String response = makeGetRequestAndReturnResponse();

        assertThat(response).isEqualTo("[]");       // harcodeo feo
    }

    @Test
    void whenThePathVariableIsGivenAndThereIsMatch_thenTheResponseHasElementsAndStatus200() throws Exception {
        List<CharacterDTO> characters = List.of(aCharacterDTO());
        when(service.find(anyString())).thenReturn(characters);

        String response = makeGetRequestAndReturnResponse();

        List<CharacterDTO> characterExpected = jsonToArray(response, CharacterDTO.class);

        assertThat(characterExpected.size()).isEqualTo(characters.size());
        assertThat(characterExpected).usingRecursiveComparison().isEqualTo(characters);
    }

    private String makeGetRequestAndReturnResponse() throws Exception {
        return mockApiRest.perform(get(PATH_FIND_CHARACTERS, QUERY)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    /*private <T> List<T> fromJson(String json) throws JsonProcessingException {
        return mapper.readValue(json, new TypeReference<>(){});
    }*/

    public <T> List<T> jsonToArray(String json, Class<T> clazz) throws JsonProcessingException {
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        return mapper.readValue(json, listType);
    }

}