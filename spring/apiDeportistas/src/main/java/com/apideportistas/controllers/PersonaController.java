package com.apideportistas.controllers;
import com.apideportistas.model.Persona;
import com.apideportistas.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService _personaService;

    //region end points
    @PostMapping("/persona")
    public int agregarPersona(@RequestBody Persona persona) {
        try{
            return _personaService.agregarPersona(persona);
        }
        catch (Exception e){
            throw  e;
        }
    }

    @GetMapping("/persona/findpersons")
    public ResponseEntity<ArrayList<Persona>> verPersonas() {
        try{
            return new ResponseEntity<>(_personaService.obtenerPersonas(), HttpStatus.OK);
        }
        catch (Exception e){
            throw  e;
        }
    }

    @GetMapping("/persona/findpersons/{nombrePersona}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable String nombrePersona) throws Exception {
        try{
            return new ResponseEntity(_personaService.buscarPersonaNombre(nombrePersona),HttpStatus.OK);
        }
        catch (Exception e){
            throw  e;
        }
    }
    //endregion
}
