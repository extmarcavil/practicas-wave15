package com.meli.blog.controller;

import com.meli.blog.dto.request.EntradaRequestDTO;
import com.meli.blog.dto.response.EntradaResponseFullDTO;
import com.meli.blog.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaController {

    @Autowired
    EntradaService service;

    @PostMapping("/blog")
    public String crearEntrada (@RequestBody EntradaRequestDTO datosEntrada) {
        Number idDevuelto = service.crearEntrada(datosEntrada);
        return "Tu post fue creado con éxito, el id de tu entrada es: " + idDevuelto;
    }

    @GetMapping("/blogs")
    public List<EntradaRequestDTO> obtenerTodasEntradas () {
        List<EntradaRequestDTO> listadoEntradas = service.obtenerTodasEntradas();
        return listadoEntradas;
    }

    @GetMapping("/blog/{id}")
    public EntradaResponseFullDTO entradaUnica (@PathVariable int id) {
        EntradaResponseFullDTO entrada = service.obtenerEntradaUnica(id);
        return entrada;
    }
}
