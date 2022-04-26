package com.example.linktracker.controller;

import com.example.linktracker.dto.request.UrlLinkDTO;
import com.example.linktracker.dto.response.IdLinkDTO;
import com.example.linktracker.service.ILinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {

    private final ILinkTrackerService service;

    public LinkTrackerController(ILinkTrackerService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<IdLinkDTO> createLink(@RequestBody UrlLinkDTO urlDTO){
        return new ResponseEntity<>(service.createLink(urlDTO), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<RedirectView> redirectLink(@RequestParam )
}
