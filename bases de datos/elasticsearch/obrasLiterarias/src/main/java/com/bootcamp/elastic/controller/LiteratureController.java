package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.service.ILiteratureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    private ILiteratureService literatureService;

    public LiteratureController(ILiteratureService literatureService){
        this.literatureService = literatureService;
    }

    @GetMapping("")
    public ResponseEntity<List<LiteratureDTO>> getBooks () {
        return ResponseEntity.ok().body(literatureService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<List<LiteratureDTO>> saveBooks (@RequestBody List<LiteratureDTO> books ) {
        return new ResponseEntity<>(literatureService.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureService.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */

    @GetMapping("/one")
    public ResponseEntity<List<LiteratureDTO>> getBooksByActor (@RequestParam String author ) {
        return new ResponseEntity<>(literatureService.findAllByAuthor(author), OK);
    }

    @GetMapping("/two")
    public ResponseEntity<List<LiteratureDTO>> getBooksByTitle (@RequestBody List<String> list ) {
        return new ResponseEntity<>(literatureService.findAllByTitle(list), OK);
    }

    @GetMapping("/three")
    public ResponseEntity<List<LiteratureDTO>> getBooksGreaterThanCantPages (@RequestParam Integer cantPages ) {
        return new ResponseEntity<>(literatureService.getBooksGreaterThanCantPages(cantPages), OK);
    }

    @GetMapping("/four")
    public ResponseEntity<List<LiteratureDTO>> getBooksBeforeDate (@RequestBody DateDTO date ) {
        return new ResponseEntity<>(literatureService.getBooksBeforeDate(date), OK);
    }

    @GetMapping("/four2")
    public ResponseEntity<List<LiteratureDTO>> getBooksAfterDate (@RequestBody DateDTO date ) {
        return new ResponseEntity<>(literatureService.getBooksAfterDate(date), OK);
    }

    @GetMapping("/five")
    public ResponseEntity<List<LiteratureDTO>> getBooksByEditorial (@RequestParam String editorial ) {
        return new ResponseEntity<>(literatureService.getBooksByEditorial(editorial), OK);
    }
}
