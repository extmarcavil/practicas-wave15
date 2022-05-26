package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.domain.Autor;
import com.bootcamp.elastic.reposaitory.ArticuloRepository;
import com.bootcamp.elastic.reposaitory.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autor")
public class AutorController {

    private ArticuloRepository articuloRepository;
    private AutorRepository autorRepository;

    public AutorController(ArticuloRepository articuloRepository, AutorRepository autorRepository) {
        this.articuloRepository = articuloRepository;
        this.autorRepository = autorRepository;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Autor a) {
        return ResponseEntity.ok(autorRepository.save(a));
    }
}
