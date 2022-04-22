package com.bootcamp.deportes.controller;

import com.bootcamp.deportes.dtos.SportDTO;
import com.bootcamp.deportes.repository.SportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> findSports(){
        return new ResponseEntity<>(SportRepository.getSport(), HttpStatus.OK );
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDTO> findSportByName(@PathVariable String name) {
        return new ResponseEntity<>(SportRepository.findSportByName(name),
                SportRepository.findSportByName(name) !=null ? HttpStatus.OK: HttpStatus.BAD_REQUEST
        );
    }

}
