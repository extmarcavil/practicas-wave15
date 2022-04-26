package ar.com.mercadolibre.bootcamp.linkinitializer.controller;

import ar.com.mercadolibre.bootcamp.linkinitializer.dto.CreateLinkDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.dto.MetricsDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.dto.ResponseLinkDTO;
import ar.com.mercadolibre.bootcamp.linkinitializer.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
// Ejercicio realizado en grupo con Lucas Fedele


@RestController
@RequestMapping("/link")
public class LinkController {
    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<ResponseLinkDTO> createLink(@RequestBody CreateLinkDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(linkService.save(dto));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable Long id, @RequestParam String password) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("https://" + linkService.getUrl(id, password)))
                .build();
    }

    @PostMapping("/{id}/invalidate")
    public ResponseEntity<String> invalidate(@PathVariable Long id) {
        linkService.invalidate(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Invalidated id " + id);
    }

    @GetMapping("/{id}/metrics")
    public ResponseEntity<MetricsDTO> metrics(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(linkService.metrics(id));
    }
}
