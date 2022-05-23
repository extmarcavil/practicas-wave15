package com.meli.elasticsearch.controller;

import com.meli.elasticsearch.domain.LiteraryWork;
import com.meli.elasticsearch.service.LiteraryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/elastic/literarywork")
public class LiteraryWorkController {

    private final LiteraryWorkService literaryWorkService;

    @Autowired
    public LiteraryWorkController(LiteraryWorkService literaryWorkService) {
        this.literaryWorkService = literaryWorkService;
    }

    @GetMapping("author/{author}")
    public List<LiteraryWork> findAllByAuthor(@PathVariable String author) {
        return literaryWorkService.findAllByAuthor(author);
    }

    @GetMapping("name/{name}")
    public List<LiteraryWork> findAllByName(@PathVariable String name) {
        return literaryWorkService.findAllByName(name);
    }

    @GetMapping("pages/{numberOfPages}")
    public List<LiteraryWork> findAllByMorePagesOf(@PathVariable Integer numberOfPages) {
        return literaryWorkService.findAllByMorePagesOf(numberOfPages);
    }

    @GetMapping("publication-before")
    public List<LiteraryWork> findAllByYearOfPublicationBeforeOf(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy")
            LocalDate yearOfPublication) {

        return literaryWorkService.findAllByYearOfPublicationBeforeOf(yearOfPublication);
    }

    @GetMapping("publication-after")
    public List<LiteraryWork> findAllByYearOfPublicationAfterOf(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy")
            LocalDate yearOfPublication) {

        return literaryWorkService.findAllByYearOfPublicationAfterOf(yearOfPublication);
    }

    @GetMapping("editorial/{editorial}")
    public List<LiteraryWork> findAllByEditorial(@PathVariable String editorial) {
        return literaryWorkService.findAllByEditorial(editorial);
    }

}
