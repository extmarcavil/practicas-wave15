package com.mercadolibre.bootcamp.agePerson.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AgeServiceImpl implements IAgeService {


    @Override
    public int getAge(int day, int month, int year) {
        int age = 0;
        LocalDate actualDate = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(year, month, day);

        age = actualDate.getYear() - dateOfBirth.getYear();
        return age;
    }
}
