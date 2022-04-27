package com.meli.morse.controller;

import com.meli.morse.core.BaseTest;
import com.meli.morse.service.MorseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static com.meli.morse.service.MorseService.CODE_NOT_VALID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class MorseControllerTest extends BaseTest {

    private static final String PATH = "/api";

    @Autowired
    private MorseController morseController;
    @Mock
    private MorseService morseService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        morseController = new MorseController(morseService);
        mockMvc = standaloneSetup(morseController).build();
    }

    @Test
    public void whenTheParameterReceivedIsValid_thenItsDecodedAndReturned() throws Exception {
        String hiEncoded = ".... --- .-.. .-";
        when(morseService.decode(hiEncoded)).thenReturn("HOLA");

        String hiDecodedExpected = getResponse("decode", hiEncoded);

        assertThat(hiDecodedExpected).isEqualTo("HOLA");
    }

    @Test
    public void whenTheParameterReceivedIsInvalid_thenADefaultMessageIsReturned() throws Exception {
        when(morseService.decode(any())).thenReturn(CODE_NOT_VALID);

        String messageExpected = getResponse("decode", any());

        assertThat(messageExpected).isEqualTo(CODE_NOT_VALID);
    }

    private String getResponse(String resource, String parameter) throws Exception {
        return mockMvc.perform(get(String.format("%s/%s/%s", PATH, resource, parameter)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

}