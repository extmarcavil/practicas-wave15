package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsRestTest {

    @InjectMocks
    RomanNumeralsRestController romanNumeralController;

    @Test
    @DisplayName("Comprobar que 1 devuelve I")
    void numberOneShouldBeI() {
        //arrange
        Integer number = 1;
        String romanExpected = "I";
        //act
        String result = romanNumeralController.toRoman(number);
        //assert
        assertEquals(romanExpected, result);
    }

    @Test
    @DisplayName("Comprobar que 4 no devuelve IIII")
    void numberFourNotShouldBeIIII() {
        //arrange
        Integer number = 4;
        String romanExpected = "IIII";
        //act
        String result = romanNumeralController.toRoman(number);
        //assert
        assertNotEquals(romanExpected, result);
    }

    @Test
    @DisplayName("Comprobar que 123 devuelve CXXIII")
    void numberShouldBeI() {
        //arrange
        Integer number = 123;
        String romanExpected = "CXXIII";
        //act
        String result = romanNumeralController.toRoman(number);
        //assert
        assertEquals(romanExpected, result);
    }

    @Test
    @DisplayName("Comprobar que devuelve el romano correcto para cada numero")
    void numberShouldBe() {
        assertAll(
                () -> assertEquals("IV", romanNumeralController.toRoman(4)),
                () -> assertEquals("IX", romanNumeralController.toRoman(9)),
                () -> assertEquals("X", romanNumeralController.toRoman(10)),
                () -> assertEquals("XL", romanNumeralController.toRoman(40)),
                () -> assertEquals("L", romanNumeralController.toRoman(50)),
                () -> assertEquals("XC", romanNumeralController.toRoman(90)),
                () -> assertEquals("C", romanNumeralController.toRoman(100)),
                () -> assertEquals("D", romanNumeralController.toRoman(500)),
                () -> assertEquals("M", romanNumeralController.toRoman(1000))
        );
    }

}
