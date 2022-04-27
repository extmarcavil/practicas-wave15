package com.meli.person.controller;

import com.meli.person.PersonApplicationTests;
import com.meli.person.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class PersonControllerTest extends PersonApplicationTests {

    private static final int AGE_EXPECTED = 31;

    @Autowired
    private PersonController personController;
    @Mock
    private PersonService personService;

    @BeforeEach
    void setUp() {
        personController = new PersonController(personService);
        when(personService.getAge(anyInt(), anyInt(), anyInt())).thenReturn(AGE_EXPECTED);
    }

    @Test
    void whenTheParamsAreValid_theAgeIsReturned() {
        assertThat(personController.calculateAge(anyInt(), anyInt(), anyInt())).isEqualTo(AGE_EXPECTED);
    }

    @Test()
    void whenTheParamsAreInvalid_theAnExceptionIsThrown() {
        when(personService.getAge(anyInt(), anyInt(), anyInt())).thenThrow(new RuntimeException());

        assertThatThrownBy(() -> personController.calculateAge(anyInt(), anyInt(), anyInt()))
                .isInstanceOf(Exception.class);
    }


}