package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.response.CharacterResponseDTO;
import com.example.starwars.service.BuscarPersonajeServiceImpl;
import com.example.starwars.service.IBuscarPersonajeService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BuscarPersonajeController {
    ModelMapper mm = new ModelMapper();
    IBuscarPersonajeService buscarPersonajeService;
    public BuscarPersonajeController(IBuscarPersonajeService buscarPersonajeService){
        this.buscarPersonajeService=buscarPersonajeService;
    }

    @GetMapping("/personaje/{name}")
    public List<CharacterResponseDTO> findByName(@PathVariable String name){
        return buscarPersonajeService.findAllByNameContains(name)
                .stream()
                .map(e -> mm.map(e, CharacterResponseDTO.class))
                .collect(Collectors.toList());
    }
}
