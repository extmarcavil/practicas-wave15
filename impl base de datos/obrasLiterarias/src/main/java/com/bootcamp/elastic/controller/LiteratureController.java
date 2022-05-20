package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.service.LiteratureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    LiteratureService literatureService;

    public LiteratureController ( LiteratureService literatureService ) {
        this.literatureService = literatureService;
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureService.getAll(), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<LiteratureDTO> books ) {
        return new ResponseEntity<>(literatureService.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureService.deleteAll();
        return new ResponseEntity<>("Datos eliminados", OK);
    }

    /* querys */
    @GetMapping("/one")
    public ResponseEntity<?> getLiteraturesByAuthorLike (@RequestParam String author) {
        return new ResponseEntity<>(literatureService.findAllByAuthorLike(author), OK);
    }

    @GetMapping("/two")
    public ResponseEntity<?> getLiteraturesByWordsInTitle (@RequestBody List<String> words) {
        return new ResponseEntity<>(literatureService.findAllByTitleIn(words), OK);
    }

    @GetMapping("/three")
    public ResponseEntity<?> getLiteraturesByCantPages (@RequestParam Integer cantPages) {
        return new ResponseEntity<>(literatureService.findAllByCantPagesGreaterThan(cantPages), OK);
    }

    @GetMapping("/four")
    public ResponseEntity<?> getLiteraturesByFirstPostBeforeThan (@RequestBody DateDTO  date) {
        return new ResponseEntity<>(literatureService.findAllByFirstPostBefore(date), OK);
    }

    @GetMapping("/four2")
    public ResponseEntity<?> getLiteraturesByFirstPostAfterThan (@RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureService.findAllByFirstPostAfter(date), OK);
    }

    @GetMapping("/five")
    public ResponseEntity<?> getLiteraturesByEditorialLike (@RequestParam String editorial) {
        return new ResponseEntity<>(literatureService.findAllByEditorialLike(editorial), OK);
    }
}
