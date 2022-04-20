package com.apideportistas.controllers;

import com.apideportistas.dto.NuevaInscripcionDTO;
import com.apideportistas.dto.PersonaDeporteDTO;
import com.apideportistas.services.IInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class InscripcionController {
    @Autowired
    private IInscripcionService _inscripcionService;

    //region end points
    @PostMapping("/inscripcion")
    public boolean agregarPersonaDeporte(@RequestBody NuevaInscripcionDTO nuevainsc) throws  Exception {
        try{
            return _inscripcionService.inscribirPersonaDeporte(nuevainsc);
        }
        catch (Exception e){
            throw  e;
        }
    }

    @GetMapping("/inscripcion")
    public ResponseEntity<ArrayList<PersonaDeporteDTO>> PersonaDeporte() throws  Exception {
        try{
            return new ResponseEntity<>(_inscripcionService.obtenerPersonasDeportes(), HttpStatus.OK);
        }
        catch (Exception e){
            throw  e;
        }
    }

    //endregion
}
