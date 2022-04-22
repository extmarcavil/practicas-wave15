package com.spring.calculadoraDeCaloria.controller;

import com.spring.calculadoraDeCaloria.DTO.ComidasDTO;
import com.spring.calculadoraDeCaloria.DTO.InfoComidaDTO;
import com.spring.calculadoraDeCaloria.DTO.IngredientesClienteDTO;
import com.spring.calculadoraDeCaloria.service.IPedirPlatoService;
import com.spring.calculadoraDeCaloria.service.PedirPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedirPlato {

    private IPedirPlatoService service;

    public PedirPlato(IPedirPlatoService service) {
        this.service = service;
    }

    @GetMapping("/calculadoraCaloria/{name}/{peso}")
    public ResponseEntity<InfoComidaDTO> pedirPlatoPath (@PathVariable String name, @PathVariable int peso, @RequestBody List<IngredientesClienteDTO> body) {
        return new ResponseEntity<>(service.getInfoPlato(name, peso, body), HttpStatus.OK);
    }
}
