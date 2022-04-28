package com.meli.convert.services.impl;

import com.meli.convert.services.PersonService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ConvertServiceImpl implements PersonService {
    @Override
    public Integer getAge(Integer day, Integer month, Integer year) {
        Period age = Period.between(LocalDate.of(year, month, day), LocalDate.now());
        return age.getYears();
    }
}
