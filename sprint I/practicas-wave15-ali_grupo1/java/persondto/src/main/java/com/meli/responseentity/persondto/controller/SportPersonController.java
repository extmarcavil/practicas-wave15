package com.meli.responseentity.persondto.controller;

import com.meli.responseentity.persondto.dto.SportPersonDto;
import com.meli.responseentity.persondto.model.Sport;
import com.meli.responseentity.persondto.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class SportPersonController {

    private final SportService sportService;

    @Autowired
    public SportPersonController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("findSports")
    public List<Sport> findSports() {
        return sportService.findAll();
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Sport> findByName(@PathVariable String name) {
        return new ResponseEntity<>(sportService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("findSportsPersons")
    public List<SportPersonDto> findSportPersons() {
        return sportService.findSportPersons();
    }

}
