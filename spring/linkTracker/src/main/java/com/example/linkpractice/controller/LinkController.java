package com.example.linkpractice.controller;

import com.example.linkpractice.DTO.request.CreateLinkDTO;
import com.example.linkpractice.DTO.response.CreateLinkDTOResponse;
import com.example.linkpractice.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    IService service;

    public LinkController(IService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<CreateLinkDTOResponse> createLink(@RequestBody CreateLinkDTO linkBody) {
        return new ResponseEntity<>(service.createLink(linkBody), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Object> redirect(@PathVariable Integer linkId) {
        String linkToRedirect = service.getLinkById(linkId);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(linkToRedirect))
                .build();
    }

}
