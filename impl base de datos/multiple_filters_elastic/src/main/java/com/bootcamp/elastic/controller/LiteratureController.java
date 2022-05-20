package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.LiteratureDTO;
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
    public ResponseEntity<?> getBooks (@RequestParam(required=false) String author,
                                       @RequestParam(required=false) String title,
                                       @RequestParam(required=false) Integer minPages,
                                       @RequestParam(required=false) Integer minYear,
                                       @RequestParam(required=false) Integer maxYear,
                                       @RequestParam(required=false) String publisher) {
        return new ResponseEntity<>(literatureService.getAll(author, title, minPages, minYear, maxYear, publisher), OK);
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
}
