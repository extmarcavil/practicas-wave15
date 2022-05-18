package com.Spring.LinkTracker.controller;


import com.Spring.LinkTracker.dto.LinkDTO;
import com.Spring.LinkTracker.service.ILinkService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    ILinkService service;

    public LinkController(ILinkService service) {
        this.service = service;
    }

    @GetMapping("/link/save/{url}")
    public ResponseEntity<Integer> saveLink(@PathVariable String url){
        return new ResponseEntity<>(service.saveLink(url),HttpStatus.OK);
    }

    @PostMapping("/link/redirect/{linkID}")
    public ResponseEntity<LinkDTO> redirect(@PathVariable Integer linkID){
        return new ResponseEntity<>(service.redirect(linkID),HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> metrics(@PathVariable Integer linkID){
        return new ResponseEntity<>(service.metrics(linkID),HttpStatus.OK);
    }

    @PostMapping("/link/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable Integer linkId){
        service.invalidate(linkId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
