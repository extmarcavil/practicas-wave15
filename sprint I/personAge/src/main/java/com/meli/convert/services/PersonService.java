package com.meli.convert.services;

import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    Integer getAge(Integer day, Integer month, Integer year);
}
