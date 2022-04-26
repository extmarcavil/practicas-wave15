package com.vparula.links.controller;

import com.vparula.links.dtos.LinkDTO;
import com.vparula.links.servicios.IServiceLink;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@RestController
public class LinksApplicationController {
        private IServiceLink service;


    public LinksApplicationController(IServiceLink service) {
        this.service = service;
    }

        @PostMapping("/link")
        public ResponseEntity<LinkDTO> createLink(@RequestParam String link, @RequestParam(required = false) String password) {
            return new ResponseEntity<LinkDTO>(service.crearLink(link, password), HttpStatus.OK);
        }



    @GetMapping("/link/{linkId}")
        public ResponseEntity<Object> redirect(@PathVariable Integer linkId, @RequestParam(required=false) String password) {
            String url = service.getLinkUrl(linkId,password);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(url))
                    .build();
        }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> cantRedirect(@PathVariable Integer linkId) {
        Integer redirects = service.getRedirects(linkId);
        return new ResponseEntity<Integer>(redirects, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkDTO> invalidarLink(@PathVariable Integer linkId) {
        return new ResponseEntity<LinkDTO>(service.invalidarLink(linkId), HttpStatus.OK);
    }


}
