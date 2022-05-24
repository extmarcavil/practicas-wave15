package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.TitleFilterDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.service.ILiteratureService;
import com.bootcamp.elastic.service.LiteratureService;
import org.springframework.http.HttpStatus;
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

    public LiteratureController(LiteratureRepository literatureRepository, ILiteratureService literatureService) {
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
    @GetMapping("/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author){
        return new ResponseEntity<>(literatureService.findByAuthor(author), OK);
    }

    @GetMapping("/title/filter")
    public ResponseEntity<?> findByTitleFilter(@RequestBody TitleFilterDTO titleFilterDTO){
        return new ResponseEntity<>(literatureService.findByFilter(titleFilterDTO), OK);
    }

    @GetMapping("/pages/{pages}")
    public ResponseEntity<?> findByPagesFilter(@PathVariable Integer pages){
        return new ResponseEntity<>(literatureService.findByPagesGreaterThan(pages), OK);
    }

    @GetMapping("/date/before")
    public ResponseEntity<?> findBeforeDate(@RequestBody DateDTO dateDTO){
        return new ResponseEntity<>(literatureService.findBeforeDate(dateDTO.getDate()),OK);
    }

    @GetMapping("/date/after")
    public ResponseEntity<?> findAfterDate(@RequestBody DateDTO dateDTO){
        return new ResponseEntity<>(literatureService.findAfterDate(dateDTO.getDate()),OK);
    }

    //five?editorial=Gigabox
    @GetMapping("/editorial")
    public ResponseEntity<?> findByEditorial(@RequestParam String editorial){
        return new ResponseEntity<>(literatureService.findByEditorial(editorial), OK);
    }
}
