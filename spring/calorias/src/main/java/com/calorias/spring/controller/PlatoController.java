package com.calorias.spring.controller;

import com.calorias.spring.modelo.PlatoDTO;
import com.calorias.spring.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    @Autowired
    PlatoService platoService;

    @GetMapping("plato/{nombre}/{peso}")
    public ResponseEntity<PlatoDTO> getInformacion(@PathVariable String nombre , @PathVariable int peso){
        platoService.getCalorias(nombre,peso);

        return null;
    }
}
