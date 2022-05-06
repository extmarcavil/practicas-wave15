package com.bootcamp.youtuber.controller;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.entities.EntradaBlog;
import com.bootcamp.youtuber.service.IEntradaBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/blog")
public class EntradaBlogController {

    /**
     * Injection by Constructor
     */
    private IEntradaBlogService entradaBlogService;

    public EntradaBlogController(IEntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    /**
     * Metodos
     */
    @PostMapping()
    public ResponseEntity<String> crearBlog(@RequestBody EntradaBlogDto blogDto) {
        entradaBlogService.guardar(blogDto);
        return new ResponseEntity<>(String.format("Blog creado correctamente con ID: %d", blogDto.getId()),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlog> findById(@PathVariable Integer id) {
        EntradaBlog entradaBlog = entradaBlogService.visualizar(id);
        return new ResponseEntity<EntradaBlog>(entradaBlog, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EntradaBlog>> findAll() {
        List<EntradaBlog> listaEntradaBlog = entradaBlogService.listar();
        return new ResponseEntity<>(listaEntradaBlog, HttpStatus.OK);
    }


}
