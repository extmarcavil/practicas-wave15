package com.meli.roman.service;

import com.meli.roman.model.RomanNumerals;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RomanNumeralsService {

    public String toRoman(Integer numberToConvert) {
        return searchSimpleRomanNumerals(numberToConvert)
                .orElseGet(() -> searchWithRecursive(numberToConvert));
    }

    private String searchWithRecursive(Integer numberToCovert) {
         Map<Integer, String> mapOfRomanNumerals = Stream.of(RomanNumerals.values())
                .collect(Collectors.toMap(
                        RomanNumerals::getValue,
                        RomanNumerals::name)
                );
        TreeMap<Integer, String> map = new TreeMap<>(mapOfRomanNumerals);
        int keyMap =  map.floorKey(numberToCovert);

        if (numberToCovert == keyMap) {
            return map.get(numberToCovert);
        }
        return map.get(keyMap) + searchWithRecursive(numberToCovert-keyMap);
    }

    private Optional<String> searchSimpleRomanNumerals(Integer number) {
        return Stream.of(RomanNumerals.values())
                .filter(bySameNumber(number))
                .map(RomanNumerals::name)
                .findFirst();
    }

    private Predicate<RomanNumerals> bySameNumber(Integer number) {
        return romanNumerals -> romanNumerals.getValue().compareTo(number) == 0;
    }

}
