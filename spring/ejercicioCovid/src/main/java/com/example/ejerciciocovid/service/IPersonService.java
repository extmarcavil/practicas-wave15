package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.dto.RiskPersonDTO;
import com.example.ejerciciocovid.model.Person;

import java.util.List;

public interface IPersonService {

    List<Person> getPersonsList();
    List<RiskPersonDTO> getRiskPersonsList();
}
