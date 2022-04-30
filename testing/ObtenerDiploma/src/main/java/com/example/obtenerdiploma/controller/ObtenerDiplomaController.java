package com.example.obtenerdiploma.controller;

import com.example.obtenerdiploma.model.StudentDTO;
import com.example.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@Valid @RequestBody StudentDTO rq) {
        return service.analyzeScores(rq);
    }
}