package com.example.linktracker.controllers;

import com.example.linktracker.dto.LinkRequestDTO;
import com.example.linktracker.dto.LinkResponseDTO;
import com.example.linktracker.services.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> saveLink(@RequestBody LinkRequestDTO link) {
        Integer id = linkService.save(link.getUrl(), link.getPassword());
        return new ResponseEntity<LinkResponseDTO>(new LinkResponseDTO(id), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public HttpEntity<Map<String, String>> redirect(@PathVariable Integer id, @RequestParam Optional<String> password) {
        URL url = linkService.redirect(id, password.orElse(null));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", url.toString());

        return new ResponseEntity<>(responseHeaders, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkResponseDTO> getMetrics(@PathVariable Integer id) {
        LinkResponseDTO link = linkService.getStatistics(id);
        return new ResponseEntity<LinkResponseDTO>(link, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<HttpStatus> invalidate(@PathVariable int id) {
        linkService.invalidate(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
