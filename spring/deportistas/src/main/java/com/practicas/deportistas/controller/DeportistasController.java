package com.practicas.deportistas.controller;

import com.practicas.deportistas.dto.Deporte;
import com.practicas.deportistas.dto.PersonaDTO;
import com.practicas.deportistas.servicios.ServicioDeportes;
import com.practicas.deportistas.servicios.ServicioPersonasDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {

    @GetMapping("findSports")
    @ResponseBody
    public List<Deporte> getDeportes(){
        return ServicioDeportes.buscarTodos();
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<String> getDeporte(@PathVariable String name){
        return new ResponseEntity<>(ServicioDeportes.buscarDeporte(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("findSportPersons")
    @ResponseBody
    public List<PersonaDTO> getPersonaDeportista(){
        return ServicioPersonasDTO.getPersonasDTO();
    }
}
