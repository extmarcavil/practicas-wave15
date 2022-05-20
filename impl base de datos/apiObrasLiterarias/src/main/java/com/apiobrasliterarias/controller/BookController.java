package com.apiobrasliterarias.controller;

import com.apiobrasliterarias.dto.BookDTO;
import com.apiobrasliterarias.service.IBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/newbooks")
    public ResponseEntity<Boolean> newBook(@RequestBody List<BookDTO> books)
    {
        return ResponseEntity.ok(bookService.addBooks(books));
    }

    @GetMapping("/author")
    public ResponseEntity<List<BookDTO>> listBooksByAuthor(@RequestParam String author)
    {
        return ResponseEntity.ok(bookService.listBooksByAuthor(author));
    }

    @GetMapping("/booktitle")
    public ResponseEntity<List<BookDTO>> listBooksByTitle(@RequestParam String booktitle)
    {
        return ResponseEntity.ok(bookService.listBooksByTitle(booktitle));
    }

    @GetMapping("/cantpages")
    public ResponseEntity<List<BookDTO>> listBooksAfterCantPages(@RequestParam int cantpages)
    {
        return ResponseEntity.ok(bookService.listBooksAfterCantPages(cantpages));
    }

    @GetMapping("/editorial")
    public ResponseEntity<List<BookDTO>> listBooksByEditorial(@RequestParam String editorial)
    {
        return ResponseEntity.ok(bookService.listBooksByEditorial(editorial));
    }

    @GetMapping("/after")
    public ResponseEntity<List<BookDTO>> listBooksByAfterYear(@RequestParam int year)
    {
        return ResponseEntity.ok(bookService.listBooksByAfterYear(year));
    }

    @GetMapping("/before")
    public ResponseEntity<List<BookDTO>> listBooksByBeforeYear(@RequestParam int year)
    {
        return ResponseEntity.ok(bookService.listBooksByBeforeYear(year));
    }
}
