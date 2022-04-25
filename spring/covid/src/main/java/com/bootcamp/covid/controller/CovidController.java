package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.model.Symptom;
import com.bootcamp.covid.service.SymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @GetMapping("/findSymptom")
    public List<SymptomDTO> findSymptom(){
        return SymptomService.findSymptom();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptomByName(@PathVariable String name) {
        return new ResponseEntity<>(SymptomService.findSymptomByName(name),
                SymptomService.findSymptomByName(name) !=null ? HttpStatus.OK: HttpStatus.BAD_REQUEST
        );
    }
}
