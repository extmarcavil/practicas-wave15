package com.example.linkpractice.controller;

import com.example.linkpractice.dtos.LinkResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody String link, @RequestParam String password) {
        return
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Object> redirect(@RequestParam String linkId) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("https://www.yahoo.com"))
                .build();
    }

}
