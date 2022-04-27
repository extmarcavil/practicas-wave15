package com.meli.morse.service;

import com.meli.morse.core.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MorseServiceTest extends BaseTest {

    private static final String HOLA_DECODED = ".... --- .-.. .-";
    private static final String MERCADOLIBRE_DECODED = "-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .";

    @Autowired
    private MorseService morseService;

    @Test
    public void whenTheMorseCodeIsValid_thenItsDecodedAndReturned() {
        assertThat(morseService.decode(HOLA_DECODED)).isEqualTo("HOLA");
    }

    @Test
    public void whenTheMorseCodeHasTwoWords_thenItsDecodedAndReturnedCorrectly() {
        assertThat(morseService.decode(MERCADOLIBRE_DECODED)).isEqualTo("MERCADO LIBRE");
    }

    @Test
    public void whenTheMorseCodeHasAWordWhitespaces_thenItsDecodedAndReturnedWithoutWhitespaceAtTheEndOfTheWord() {
        assertThat(morseService.decode(String.format(HOLA_DECODED+"   "))).isEqualTo("HOLA");
    }

    @Test
    public void whenTheMorseCodeHasThreeWords_thenItsDecodedAndReturnedCorrectly() {
        String hiFreeMarketDecoded = String.format(HOLA_DECODED+"   %s", MERCADOLIBRE_DECODED);
        assertThat(morseService.decode(hiFreeMarketDecoded)).isEqualTo("HOLA MERCADO LIBRE");
    }

    @Test
    public void whenTheMorseCodeHasAWhitespaceAndTwoWords_thenItsReturnedWithoutWhitespaceAtTheEndOfTheWord() {
        String springEncoded = "... .--. .-. .. -. --.";
        String encodedWithTwoWords = String.format(HOLA_DECODED +"   %s", springEncoded);

        assertThat(morseService.decode(encodedWithTwoWords)).isEqualTo("HOLA SPRING");
    }

    @ParameterizedTest
    @MethodSource("validMorseCodes")
    public void validateAllMorseCodesAreValid(String keyEncoded, String valueDecoded) {
        assertThat(Map.of(keyEncoded, valueDecoded).get(keyEncoded)).isEqualTo(valueDecoded);
    }

    public static Stream<Arguments> validMorseCodes() {
        return Stream.of(
                Map.ofEntries(
                        Map.entry(".-", "A"), Map.entry("-...", "B"),
                        Map.entry("-.-.", "C"), Map.entry("-..", "D"),
                        Map.entry(".", "E"), Map.entry("..-.", "F"),
                        Map.entry("--.", "G"), Map.entry("....", "H"),
                        Map.entry("..", "I"), Map.entry(".---", "J"),
                        Map.entry("-.-", "K"), Map.entry(".-..", "L"),
                        Map.entry("--", "M"), Map.entry("-.", "N"),
                        Map.entry("---", "O"), Map.entry(".--.", "P"),
                        Map.entry("--.-", "Q"), Map.entry(".-.", "R"),
                        Map.entry("...", "S"), Map.entry("-", "T"),
                        Map.entry("..-", "U"), Map.entry("...-", "V"),
                        Map.entry("-.--", "Y"), Map.entry("-..-", "X"),
                        Map.entry(".----", "1"), Map.entry("..---", "2"),
                        Map.entry("...--", "3"), Map.entry("....-", "4"),
                        Map.entry(".....", "5"), Map.entry("-....", "6"),
                        Map.entry("--...", "7"), Map.entry("---..", "8"),
                        Map.entry("----.", "9"), Map.entry("-----", "0"),
                        Map.entry("..--..", "?"), Map.entry("-.-.--", "!"),
                        Map.entry(".-.-.-", "."), Map.entry("--..--", ",")
                )
        ).flatMap(map -> map.entrySet()
                .stream().map(value -> Arguments.of(value.getKey(), value.getValue())));
    }

}