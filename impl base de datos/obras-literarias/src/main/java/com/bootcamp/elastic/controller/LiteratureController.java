package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDto;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.service.LiteratureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/literature")
public class LiteratureController {

    private final LiteratureService service;

    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(service.getAll(), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks( @RequestBody List<LiteratureDto> books ) {
        service.saveAll(books);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/one")
    public ResponseEntity<?> getBooksByAuthor(@RequestParam String author){
        return ResponseEntity.ok(service.getByAuthor(author));
    }

    @GetMapping("/two")
    public ResponseEntity<?> getBooksByAuthor(@RequestBody List<String> words){
        return ResponseEntity.ok(service.getByContainsWords(words));
    }

    @GetMapping("/three")
    public ResponseEntity<?> getBooksByCantPagGreaterThan(@RequestParam Integer cant){
        return ResponseEntity.ok(service.getByCantPagGreaterThan(cant));
    }

    @GetMapping("/four")
    public ResponseEntity<?> getBooksByDateBefore(@RequestBody DateDTO dateDTO){
        return ResponseEntity.ok(service.getByDateBefore(dateDTO));
    }

    @GetMapping("/four2")
    public ResponseEntity<?> getBooksByDateAfter(@RequestBody DateDTO dateDTO){
        return ResponseEntity.ok(service.getByDateAfter(dateDTO));
    }

    @GetMapping("/five")
    public ResponseEntity<?> getBooksByDateAfter(@RequestParam String editorial){
        return ResponseEntity.ok(service.getByEditorial(editorial));
    }


}
