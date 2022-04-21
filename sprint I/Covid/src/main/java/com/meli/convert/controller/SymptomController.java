package com.meli.convert.controller;

import com.meli.convert.model.Sintoma;
import com.meli.convert.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/findSymptom")
public class SymptomController {

    @Autowired
    private CovidService covidService;

    @GetMapping("/")
    public ResponseEntity<List<Sintoma>> getAllSymptoms() {
        return new ResponseEntity<>(this.covidService.getAllSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Sintoma> getSymptom(@PathVariable String name) {
        return new ResponseEntity<>(this.covidService.getSymptom(name), HttpStatus.OK);
    }
}
