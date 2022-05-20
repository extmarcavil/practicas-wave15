package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.request.DateDTO;
import com.bootcamp.elastic.request.LiteratureDto;
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

    ILiteratureService service;

    public LiteratureController(ILiteratureService service, LiteratureRepository literatureRepository ) {
        this.literatureRepository = literatureRepository;
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<LiteratureDto>> getBooks () {
        return ResponseEntity.ok().body(service.getBooks());
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<LiteratureDto> books ) {
        return ResponseEntity.ok().body(service.saveAllBooks(books));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */
    // Retornar las obras de un autor dado por el usuario.
    //http://localhost:8080/literature/one?author=Springle
    @GetMapping("/one")
    public ResponseEntity<List<LiteratureDto>> getBooksAuthor (@RequestParam String author) {
        return ResponseEntity.ok().body(service.getBooksAuthor(author));
    }

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    //http://localhost:8080/literature/two
   /* [
            "the"
            ]*/
    @GetMapping("/two")
    public ResponseEntity<List<LiteratureDto>> getBooksTile (@RequestBody List<String> title) {
        return ResponseEntity.ok().body(service.getBooksTitle(title));
    }

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    //http://localhost:8080/literature/three?cantPages=2980
    @GetMapping("/three")
    public ResponseEntity<List<LiteratureDto>> getBooksMasCantPages (@RequestParam Integer cantPages) {
        return ResponseEntity.ok().body(service.getBooksMasCantPages(cantPages));
    }

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    //http://localhost:8080/literature/four
    @GetMapping("/four")
    public ResponseEntity<List<LiteratureDto>> getBooksDateAfter (@RequestBody DateDTO date) {
        return ResponseEntity.ok().body(service.getBooksDateAfter(date));
    }

    //http://localhost:8080/literature/four2
    @GetMapping("/four2")
    public ResponseEntity<List<LiteratureDto>> getBooksDateBefore (@RequestBody DateDTO date) {
        return ResponseEntity.ok().body(service.getBooksDateBefore(date));
    }

    //Retornar las obras de una misma editorial.
    //http://localhost:8080/literature/five?editorial=Shufflebeat
    @GetMapping("/five")
    public ResponseEntity<List<LiteratureDto>> getBooksEditorial (@RequestParam String editorial) {
        return ResponseEntity.ok().body(service.getBooksEditorial(editorial));
    }

}
