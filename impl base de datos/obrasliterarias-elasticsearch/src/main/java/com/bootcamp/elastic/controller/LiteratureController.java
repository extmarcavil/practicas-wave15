package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.service.LiteratureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    private final LiteratureService literatureService;

    public LiteratureController (LiteratureService literatureService ) {
        this.literatureService = literatureService;
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureService.findAll(), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<LiteratureDTO> books ) {
        return new ResponseEntity<>(literatureService.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureService.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */

    @GetMapping("/one")
    public ResponseEntity<?> getAllByAuthor (@RequestParam String author) {
        return new ResponseEntity<>(literatureService.findAllByAuthor(author), OK);
    }

    @GetMapping("/two")
    public ResponseEntity<?> getAllByTitle (@RequestBody List<String> words) {
        return new ResponseEntity<>(literatureService.findAllByTitleIn(words), OK);
    }

    @GetMapping("/three")
    public ResponseEntity<?> getAllByMorePagesThan (@RequestParam Integer cantPages) {
        return new ResponseEntity<>(literatureService.findAllByCantPagesGreaterThan(cantPages), OK);
    }

    @GetMapping("/four")
    public ResponseEntity<?> getByFirsPostBefore (@RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureService.findAllByFirstPostBefore(date.getDate()), OK);
    }

    @GetMapping("/four2")
    public ResponseEntity<?> getByFirsPostAfter (@RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureService.findAllByFirstPostAfter(date.getDate()), OK);
    }

    @GetMapping("/five")
    public ResponseEntity<?> getAllByEditorial (@RequestParam String editorial) {
        return new ResponseEntity<>(literatureService.findAllByEditorial(editorial), OK);
    }
}
