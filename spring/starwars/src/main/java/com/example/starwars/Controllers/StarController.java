package com.example.starwars.Controllers;


import com.example.starwars.Service.CharacterService;
import com.example.starwars.Service.CharacterServiceImpl;
import com.example.starwars.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarController {

    @Autowired
    private CharacterServiceImpl characterService;

    @GetMapping("/star/{name}")
    public ResponseEntity<List<CharacterDTO>>findbyName(@PathVariable String name){

       return new ResponseEntity<>(characterService.findByname(name), HttpStatus.OK);
    }




}
