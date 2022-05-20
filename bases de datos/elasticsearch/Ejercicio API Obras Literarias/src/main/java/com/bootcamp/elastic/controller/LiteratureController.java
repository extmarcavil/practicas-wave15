package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    LiteratureRepository literatureRepository;

    public LiteratureController ( LiteratureRepository literatureRepository ) {
        this.literatureRepository = literatureRepository;
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */

    //1) Retornar las obras de un autor dado por el usuario.
    @GetMapping("/one")
    public ResponseEntity<?> findBooksByAuthorName (@RequestParam String author) {
        return new ResponseEntity<>(literatureRepository.findAllByAuthorLike(author), OK);
    }

    //2) Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @GetMapping("/two")
    public ResponseEntity<?> findBooksByTitleContains (@RequestBody List<String> title) {
        return new ResponseEntity<>(literatureRepository.findAllByTitleIn(title), OK);
    }

    //3) Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @GetMapping("/three")
    public ResponseEntity<?> findBooksByCantPages (@RequestParam Integer cantPages) {
        return new ResponseEntity<>(literatureRepository.findAllByCantPagesGreaterThan(cantPages), OK);
    }

    //4) Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    @GetMapping("/four")
    public ResponseEntity<?> findBooksByFirstPostBefore (@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostBefore(dateDTO.getDate()), OK);
    }

    @GetMapping("/four2")
    public ResponseEntity<?> findBooksByFirstPostAfter (@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostAfter(dateDTO.getDate()), OK);
    }

    //5) Retornar las obras de una misma editorial.
    @GetMapping("/five")
    public ResponseEntity<?> findBooksByEditorialName (@RequestParam String editorial) {
        return new ResponseEntity<>(literatureRepository.findAllByEditorialLike(editorial), OK);
    }
}
