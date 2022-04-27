package com.meli.roman.controller;

import com.meli.roman.core.BaseTest;
import com.meli.roman.service.RomanNumeralsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class RomanControllerTest extends BaseTest {

    private static final String PATH = "/api";

    @Autowired
    private RomanController romanController;
    @Mock
    private RomanNumeralsService romanNumeralsService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        romanController = new RomanController(romanNumeralsService);
        mockMvc = standaloneSetup(romanController).build();
    }

    @Test
    public void whenTheParameterReceivedIsANumber_thenItsConvertedAndReturned() throws Exception {
        Integer valueToConvert = 10;
        String valueExpected = "X";
        when(romanNumeralsService.toRoman(valueToConvert)).thenReturn(valueExpected);

        String valueConverted = mockMvc.perform(get(String.format("%s/convert/%s", PATH, valueToConvert)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(valueExpected).isEqualTo(valueConverted);
    }

    @ParameterizedTest
    @MethodSource("invalidParameters")
    public void whenTheParameterReceivedIsInvalid_thenAnExceptionIsThrown(String invalidParameter) throws Exception {
        mockMvc.perform(get(String.format("%s/convert/%s", PATH, invalidParameter)))
                .andExpect(invalidParameter.isBlank() ? status().is5xxServerError() : status().is4xxClientError())
                .andExpect(response -> {
                    Exception exception = response.getResolvedException();
                    if (response.getResponse().getStatus() == BAD_REQUEST.value()) {
                        assertThat(exception instanceof MethodArgumentTypeMismatchException).isTrue();
                        assertThat(exception.getMessage()).contains("Failed to convert value of type");
                    } else {
                        assertThat(exception instanceof MissingPathVariableException).isTrue();
                        assertThat(exception.getMessage()).contains("Required URI template variable");
                    }
                });
    }

    public static Stream<String> invalidParameters() {
        return Stream.of("       ", "-", "asdasda", "\t", "\n");
    }

}