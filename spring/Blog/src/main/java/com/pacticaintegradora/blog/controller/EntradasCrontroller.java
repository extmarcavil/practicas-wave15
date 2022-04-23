package com.pacticaintegradora.blog.controller;

import com.pacticaintegradora.blog.exception.EntradaExistenteException;
import com.pacticaintegradora.blog.exception.EntradaNoEncontradaException;
import com.pacticaintegradora.blog.model.EntradaBlog;
import com.pacticaintegradora.blog.service.IEntradaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradasCrontroller {

    private IEntradaService entradaService;

    public EntradasCrontroller(IEntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @PostMapping("/nuevaEntrada")
    public ResponseEntity<String> nuevaEntrada(@RequestBody EntradaBlog entradaBlog) {
        return ResponseEntity.ok("El blog con id " + entradaService.nuevaEntrada(entradaBlog) +
                                 " ha sido creado correctamente");
    }

    @GetMapping("/entradas")
    public ResponseEntity<List<EntradaBlog>> entradasCreadas() {
        return ResponseEntity.ok(entradaService.entradasCreadas());
    }

    @GetMapping("/entrada/{id}")
    public ResponseEntity<?> buscarEntrada(@PathVariable Long id) {
        return ResponseEntity.ok(entradaService.buscarEntrada(id));
    }

    @ExceptionHandler(EntradaExistenteException.class)
    public ResponseEntity<?> handlerEntradaExistenteException(Exception e) {
        return ResponseEntity.status(HttpStatus.FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EntradaNoEncontradaException.class)
    public ResponseEntity<?> handlerEntradaNoEncontradaException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
