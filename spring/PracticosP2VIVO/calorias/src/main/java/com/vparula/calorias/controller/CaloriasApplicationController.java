package com.vparula.calorias.controller;

import com.vparula.calorias.DTO.IngredienteDTO;
import com.vparula.calorias.model.Ingrediente;
import com.vparula.calorias.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloriasApplicationController {
    @Autowired
    IService servicio;

    @GetMapping("/getCalorias/{name}")
    public  ResponseEntity<Integer> cantidadCaloriasPlato (@PathVariable String name ) {
        Integer resultado =servicio.getCalorias(name);
        if (resultado!=-1) {
            return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
        }else{
            return new ResponseEntity<Integer>(resultado, HttpStatus.BAD_REQUEST);
        }
        //return new ResponseEntity<>(service.getSymptoms(), HttpStatus.OK);
    }
    @GetMapping("/getIngredientes/{name}")
    public  ResponseEntity<IngredienteDTO> ingredientesPlato (@PathVariable String name ) {
        IngredienteDTO ingredientes = servicio.getIngredients(name);
        return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }

}
