package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.WordsDTO;
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

    @GetMapping("/books")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @GetMapping("/books/{autor}")
    public ResponseEntity<?> getBooksByAutor (@PathVariable String autor) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByAuthorEquals(autor), OK);
    }

//    @GetMapping("/books/with")
//    public ResponseEntity<?> getBooksWithWordsinTittle (@RequestBody WordsDTO words) {
//        return new ResponseEntity<>(literatureRepository.findLiteratureByTitleContaining(words.getWords()), OK);
//    }

    @GetMapping("/books/with")
    public ResponseEntity<?> getBooksWithWordsinTittle (@RequestParam String word) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByTitleContaining(word), OK);
    }

    @GetMapping("/books/bigger")
    public ResponseEntity<?> getBooksBiggerThan (@RequestParam Integer pages) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByCantPagesGreaterThan(pages), OK);
    }

    @GetMapping("/books/before")
    public ResponseEntity<?> getBooksBeforeThan (@RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByFirstPostBefore(date.getDate()), OK);
    }

    @GetMapping("/books/after")
    public ResponseEntity<?> getBooksAfterThan (@RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByFirstPostAfter(date.getDate()), OK);
    }

    @GetMapping("/books/{editorial}")
    public ResponseEntity<?> getBooksByEditorial (@PathVariable String editorial) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByEditorialEquals(editorial), OK);
    }

    @PostMapping("/save")
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
