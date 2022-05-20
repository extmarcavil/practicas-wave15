package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
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

    LiteratureRepository literatureRepository;
    ILiteratureService literatureService;
    public LiteratureController ( LiteratureRepository literatureRepository, ILiteratureService literatureService ) {
        this.literatureRepository = literatureRepository;
        this.literatureService = literatureService;
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
    @GetMapping("/one")
    public ResponseEntity<?> getBooksByAutor(@RequestParam String author){
        return ResponseEntity.ok().body(literatureService.getBooksByAutor(author));
    }

    @GetMapping("/two")
    public ResponseEntity<?> getBooksWithWordsInTitle(@RequestBody List<String> words)
    {
        return ResponseEntity.ok().body(literatureService.getBooksWithWordsInTitle(words.get(0)));
    }

    @GetMapping("/three")
    public ResponseEntity<?> getBooksWithPagesGreaterThan(@RequestParam Integer cantPages)
    {
        return ResponseEntity.ok().body(literatureService.getBooksWithPagesGreaterThan(cantPages));
    }

    @GetMapping("/four")
    public ResponseEntity<?> getBooksBefore(@RequestBody DateDTO date)
    {
        return ResponseEntity.ok().body(literatureService.getBooksBefore(date));
    }

    @GetMapping("/four2")
    public ResponseEntity<?> getBooksAfter(@RequestBody DateDTO date)
    {
        return ResponseEntity.ok().body(literatureService.getBooksAfter(date));
    }

    @GetMapping("/five")
    public ResponseEntity<?> getBooksByEditorial(@RequestParam String editorial){
        return ResponseEntity.ok().body(literatureService.getBooksByEditorial(editorial));
    }


}
