package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody StudentDTO rq) {
        return service.analyzeScores(rq);
    }
}

//Colocar @Valid dentro del argumento de la lista de DTO para que tome las validaciones del DTO
//MethodNotValidArgumentException es el error que salta con cualquier validación

//Arrange Definición de datos
//Act Ejecutar el código
//Assert Comprobar el resultado de la ejecución del código
