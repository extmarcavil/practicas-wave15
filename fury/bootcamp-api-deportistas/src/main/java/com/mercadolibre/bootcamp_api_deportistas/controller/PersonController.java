package com.mercadolibre.bootcamp_api_deportistas.controller;

import com.mercadolibre.bootcamp_api_deportistas.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons() {
        return ResponseEntity.ok(personService.findSportsPersons());
    }
}
