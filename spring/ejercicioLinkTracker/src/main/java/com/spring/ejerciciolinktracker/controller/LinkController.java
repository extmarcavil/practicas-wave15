package com.spring.ejerciciolinktracker.controller;

import com.spring.ejerciciolinktracker.dto.ResponseLinkDTO;
import com.spring.ejerciciolinktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;

@RestController
public class LinkController {

    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLink(@RequestBody String url) {
        return new ResponseEntity<>(linkService.createLink(url), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ModelAndView redirectLink(@PathVariable String linkId) {
        String url = linkService.getLinkRedirect(linkId);
        return new ModelAndView(("redirect:https://" + url));
    }


    public ResponseEntity<Void> redirectLink2(@PathVariable String link) {
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("https://" + linkService.getLinkRedirect(link))).
                build();
    }
}

