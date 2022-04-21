package com.apistarwars.controller;

import com.apistarwars.dto.PersonajeDTO;
import com.apistarwars.service.IPersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {
    //region Variables
    private IPersonajeService _personajeService;
    //endregion

    //region Constructor

    public StarWarsController(IPersonajeService personajeService) {
        this._personajeService = personajeService;
    }


    //endregion

    //region end points
    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> listSymptoms (@PathVariable String nombre) {
        return new ResponseEntity<>(_personajeService.likeByNombre(nombre), HttpStatus.OK);
    }
    //endregion
}
