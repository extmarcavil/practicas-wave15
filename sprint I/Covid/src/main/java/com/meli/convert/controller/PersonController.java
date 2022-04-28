package com.meli.convert.controller;

import com.meli.convert.model.Persona;
import com.meli.convert.services.CovidService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController {

    @Qualifier
    CovidService covidService;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Persona>> getRiskPersons() {
        return new ResponseEntity<>(this.covidService.getRiskPersons(), HttpStatus.OK);
    }
}
