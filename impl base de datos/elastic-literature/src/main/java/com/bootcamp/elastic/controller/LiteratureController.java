package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.LiteratureDto;
import com.bootcamp.elastic.dto.request.DateDTO;
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
        return new ResponseEntity<>(literatureService.findAll(), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<LiteratureDto> books ) {
        return new ResponseEntity<>(literatureService.saveAll(books), CREATED);
    }

    @GetMapping("/one")
    public ResponseEntity<List<LiteratureDto>> findOneAuthor(@RequestParam String author) {
        return ResponseEntity.ok(literatureService.findAllByAuthor(author));
    }

    @GetMapping("/two")
    public ResponseEntity<List<LiteratureDto>> findByTitleContainsAny(@RequestBody List<String> words) {
        return ResponseEntity.ok(literatureService.findAllByTitleContainsAny(words));
    }

    @GetMapping("/three")
    public ResponseEntity<List<LiteratureDto>> findByPages(@RequestParam Integer cantPages) {
        return ResponseEntity.ok(literatureService.findAllByCantPagesGreaterThan(cantPages));
    }

    @GetMapping("/four")
    public ResponseEntity<List<LiteratureDto>> findByFirstPostBefore(@RequestBody DateDTO dto) {
        return ResponseEntity.ok(literatureService.findAllByFirstPostBefore(dto));
    }

    @GetMapping("/four2")
    public ResponseEntity<List<LiteratureDto>> findByFirstPostAfter(@RequestBody DateDTO dto) {
        return ResponseEntity.ok(literatureService.findAllByFirstPostAfter(dto));
    }

    @GetMapping("/five")
    public ResponseEntity<List<LiteratureDto>> findAllByEditorial(@RequestParam String editorial) {
        return ResponseEntity.ok(literatureService.findAllByEditorial(editorial));
    }

    /*@DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }*/

    /* querys */
}
