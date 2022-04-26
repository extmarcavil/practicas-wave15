package com.example.demo.controller;

import com.example.demo.dto.LinkDTO;
import com.example.demo.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addLink(@RequestBody LinkDTO linkDTO){
        return new ResponseEntity<>(linkService.addLink(linkDTO), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable int id){

        return new RedirectView(linkService.getURLByID(id));
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> getMetrics(@PathVariable int linkID){


    }

}
