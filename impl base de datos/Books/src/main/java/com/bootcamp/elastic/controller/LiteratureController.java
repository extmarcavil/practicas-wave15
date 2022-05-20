package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping("one")
    public ResponseEntity<?> saveBook ( @RequestBody Literature book ) {
        return new ResponseEntity<>(literatureRepository.save(book), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */

    @GetMapping("one")
    public ResponseEntity<?> getBooksByAuthor(@RequestParam String author) {
        return new ResponseEntity<> (literatureRepository.findByAuthor(author), OK);
    }

    @GetMapping("two")
    public ResponseEntity<?> getBooksByWords(@RequestBody List<String> words) {
        return new ResponseEntity<> (literatureRepository.findByTitleLike(words), OK);
    }

    @GetMapping("three")
    public ResponseEntity<?> getBooksByCantPages(@RequestParam Integer cantPages) {
        return new ResponseEntity<> (literatureRepository.findByCantPagesGreaterThan(cantPages), OK);
    }

    @GetMapping("four")
    public ResponseEntity<?> getBooksByFirstPostBefore(@RequestBody DateDTO date) {
        return new ResponseEntity<> (literatureRepository.findByFirstPostBefore(date.getDate()), OK);
    }

    @GetMapping("four2")
    public ResponseEntity<?> getBooksByFirstPostAfter(@RequestBody DateDTO date) {
        return new ResponseEntity<> (literatureRepository.findByFirstPostAfter(date.getDate()), OK);
    }

    @GetMapping("five")
    public ResponseEntity<?> getBooksByEAditorial(@RequestParam String editorial) {
        return new ResponseEntity<> (literatureRepository.findByEditorial(editorial), OK);
    }
}
