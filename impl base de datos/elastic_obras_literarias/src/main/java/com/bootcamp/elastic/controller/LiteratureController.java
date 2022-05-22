package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.service.ILiteratureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    private final ILiteratureService service;

    public LiteratureController(ILiteratureService service) {
        this.service = service;
    }

    /**
     * Retornar las obras.
     *
     * @return ResponseEntity
     */
    @GetMapping("")
    public ResponseEntity<List<Literature>> getBooks() {
        return new ResponseEntity<>(service.getBooks(), OK);
    }

    /**
     * Retornar las obras de un autor dado por el usuario.
     *
     * @param author String
     * @return ResponseEntity
     */
    @GetMapping("/one")
    public ResponseEntity<List<Literature>> getBooksAuthor(@RequestParam String author) {
        return new ResponseEntity<>(service.getBooksByAuthor(author), OK);
    }

    /**
     * Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
     *
     * @param titleWords String
     * @return ResponseEntity
     */
    @GetMapping("/two")
    public ResponseEntity<List<Literature>> getBooksByTitle(@RequestBody List<String> titleWords) {
        return new ResponseEntity<>(service.getBooksByTitle(titleWords), OK);
    }

    /**
     * Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
     *
     * @param cantPages Integer
     * @return ResponseEntity
     */
    @GetMapping("/three")
    public ResponseEntity<List<Literature>> getBooksbyPages(@RequestParam(required = false) Integer cantPages) {
        return new ResponseEntity<>(service.getBooksWithPagesGreaterThan(cantPages), OK);
    }

    /**
     * Retornar las obras que fueron publicadas antes de un año dado por el usuario.
     *
     * @param dateDTO DateDTO
     * @return ResponseEntity
     */
    @GetMapping("/four")
    public ResponseEntity<List<Literature>> getBooksBeforeYear(@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(service.getBooksBeforeYear(dateDTO), OK);
    }

    /**
     * Retornar las obras que fueron publicadas después de un año dado por el usuario.
     *
     * @param dateDTO DateDTO
     * @return ResponseEntity
     */
    @GetMapping("/four2")
    public ResponseEntity<List<Literature>> getBooksAfterYear(@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(service.getBooksAfterYear(dateDTO), OK);
    }

    /**
     * Retornar las obras de una misma editorial.
     *
     * @param editorial String
     * @return ResponseEntity
     */
    @GetMapping("/five")
    public ResponseEntity<List<Literature>> getBooksByEditorial(@RequestParam String editorial) {
        return new ResponseEntity<>(service.getBooksByEditorial(editorial), OK);
    }

    @PostMapping("/save_all")
    public ResponseEntity<List<Literature>> saveAllBooks(@RequestBody List<Literature> books) {
        return new ResponseEntity<>(service.saveAllBooks(books), CREATED);
    }
}
