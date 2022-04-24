package ar.com.mercadolibre.bootcamp.lfedele.youtuber.controller;

import ar.com.mercadolibre.bootcamp.lfedele.youtuber.dto.EntradaBlogDto;
import ar.com.mercadolibre.bootcamp.lfedele.youtuber.service.EntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class EntradaBlogController {
    private final EntradaBlogService entradaBlogService;

    public EntradaBlogController(EntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlogDto>> findAll() {
        return new ResponseEntity<>(entradaBlogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(entradaBlogService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody EntradaBlogDto entradaBlogDto) {
        return new ResponseEntity<>(
                "Entrada creada, id: " + entradaBlogService.save(entradaBlogDto),
                HttpStatus.OK
        );
    }
}
