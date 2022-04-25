package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dtos.response.LinkDTO;
import com.bootcamp.linktracker.service.ILinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/link")
public class LinkController {

    private ILinkService linkService;

    @PostMapping
    ResponseEntity<Integer> save(@Valid @RequestBody LinkDTO link) {
        return new ResponseEntity<>(linkService.save(link), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<String> getLink(@PathVariable Integer id , @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(linkService.getLink(id, password)))
                .build();
    }

    @PostMapping("invalidate/{id}")
    ResponseEntity<LinkDTO> validate(@PathVariable Integer id){
        return new ResponseEntity<>(linkService.invalidate(id), HttpStatus.OK);
    }

    @GetMapping("/metrics/{id}")
    ResponseEntity<Integer> getCount(@PathVariable Integer id){
        return new ResponseEntity<>(linkService.getCount(id), HttpStatus.OK);
    }
}
