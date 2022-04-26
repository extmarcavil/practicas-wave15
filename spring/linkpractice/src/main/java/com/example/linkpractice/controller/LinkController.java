package com.example.linkpractice.controller;

import com.example.linkpractice.dtos.LinkResponseDTO;
import com.example.linkpractice.repository.IRepository;
import com.example.linkpractice.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    IService linkService;

    public LinkController(IService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestParam String link, @RequestParam String password) {
        return ResponseEntity.ok(linkService.createLink(link, password));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Object> redirect(@PathVariable Integer linkId) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(linkService.redirect(linkId)))
                .build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> estadistics(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.getVisits(linkId));
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidate(@PathVariable Integer linkId) {
        return ResponseEntity.ok("Ha sido invalidado");
    }

}
