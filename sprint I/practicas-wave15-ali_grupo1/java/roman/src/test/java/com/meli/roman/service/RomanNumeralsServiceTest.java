package com.meli.roman.service;

import com.meli.roman.core.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RomanNumeralsServiceTest extends BaseTest {

    @Autowired
    private RomanNumeralsService romanNumeralsService;

    @ParameterizedTest
    @MethodSource("simpleRomanNumerals")
    public void whenTheNumberIsIncludedInSimpleRomanNumerals_thenItsAssociatedValueIsReturned(
            Integer number, String valueConverted) {

        assertThat(romanNumeralsService.toRoman(number)).isEqualTo(valueConverted);
    }
    public static Stream<Arguments> simpleRomanNumerals() {
        return Stream.of(
          Arguments.of(1, "I"),
          Arguments.of(4, "IV"),
          Arguments.of(5, "V"),
          Arguments.of(9, "IX"),
          Arguments.of(10, "X"),
          Arguments.of(40, "XL"),
          Arguments.of(50, "L"),
          Arguments.of(90, "XC"),
          Arguments.of(100, "C"),
          Arguments.of(400, "CD"),
          Arguments.of(500, "D"),
          Arguments.of(900, "CM"),
          Arguments.of(1000, "M")
        );
    }

    @Test
    public void whenTheNumberIsNotIncludedInSimpleRomanNumerals_thenItsConvertAndReturned() {
        assertThat(romanNumeralsService.toRoman(11)).isEqualTo("XI");
    }
}