package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
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

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    @GetMapping("/author")
    public ResponseEntity<?> getBooksByAuthor(@RequestParam String name){
        return new ResponseEntity<>(literatureRepository.findAllByAuthor(name), OK);
    }

    @GetMapping("/title")
    public ResponseEntity<?> getBooksByTitle(@RequestParam String title){
        return new ResponseEntity<>(literatureRepository.findAllByTitleLike(title), OK);
    }

    @GetMapping("/cantPages")
    public ResponseEntity<?> getBooksWithMorePagesThan(@RequestParam int amount){
        return new ResponseEntity<>(literatureRepository.findAllByCantPagesGreaterThan(amount), OK);
    }

    @GetMapping ("/dateBefore")
    public ResponseEntity<?> getBooksPublishedBefore(@RequestParam int year){
        LocalDate queryDate = LocalDate.of(year,1,1);
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostBefore(queryDate), OK);
    }

    @GetMapping ("/dateAfter")
    public  ResponseEntity<?> getBooksPublishedAfter(@RequestParam int year){
        LocalDate queryDate = LocalDate.of(year,12,31);
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostAfter(queryDate), OK);
    }

    @GetMapping ("/editorial")
    public ResponseEntity<?> getBooksByEditorial(@RequestParam String edit){
        return new ResponseEntity<>(literatureRepository.findAllByEditorial(edit), OK);
    }

    /* querys */
}
