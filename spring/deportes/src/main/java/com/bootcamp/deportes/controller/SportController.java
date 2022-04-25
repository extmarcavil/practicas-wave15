package com.bootcamp.deportes.controller;

import com.bootcamp.deportes.dtos.PersonSportDTO;
import com.bootcamp.deportes.dtos.SportDTO;
import com.bootcamp.deportes.service.SportService;
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
        return new ResponseEntity<>(SportService.getSport(), HttpStatus.OK );
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<SportDTO> findSportByName(@PathVariable String name) {
        return new ResponseEntity<>(SportService.findSportByName(name),
                SportService.findSportByName(name) !=null ? HttpStatus.OK: HttpStatus.BAD_REQUEST
        );
    }
    
    @GetMapping("/findSportsPersons")
    public  List<PersonSportDTO> findPersonSport( ){
        return SportService.getPersonSport();
    }
    

}
