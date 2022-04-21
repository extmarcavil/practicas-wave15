package com.meli.person.service;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;

import static java.time.Period.between;

@Service
public class PersonService {

    public static final ZoneId ZONE_ID = ZoneId.of("America/Buenos_Aires");

    public int getAge(int day, int month, int year) {
        try {
            return between(LocalDate.of(year, month, day), LocalDate.now(ZONE_ID)).getYears();
        } catch (DateTimeException err) {
            throw new RuntimeException(err.getMessage()); // here custom exception's better
        }
    }
}
