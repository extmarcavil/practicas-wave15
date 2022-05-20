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

    @GetMapping("/one")
    public ResponseEntity<?> getBooksByAutor (@RequestParam String author) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByAuthorEquals(author), OK);
    }

    @GetMapping("/two")
    public ResponseEntity<?> getBooksWithWordsinTittle (@RequestBody List<String> words) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByTitleIn(words), OK);
    }

    @GetMapping("/three")
    public ResponseEntity<?> getBooksBiggerThan (@RequestParam Integer cantPages) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByCantPagesGreaterThan(cantPages), OK);
    }

    @GetMapping("/four")
    public ResponseEntity<?> getBooksBeforeThan (@RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByFirstPostBefore(date.getDate()), OK);
    }

    @GetMapping("/four2")
    public ResponseEntity<?> getBooksAfterThan (@RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByFirstPostAfter(date.getDate()), OK);
    }

    @GetMapping("/five")
    public ResponseEntity<?> getBooksByEditorial (@RequestParam String editorial) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByEditorial(editorial), OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */
}
