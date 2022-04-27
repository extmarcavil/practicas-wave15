package com.example.linktracker.controller;

import com.example.linktracker.dto.request.UrlLinkDTO;
import com.example.linktracker.dto.response.IdLinkDTO;
import com.example.linktracker.dto.response.MetricsLinkDTO;
import com.example.linktracker.service.ILinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

@RestController
public class LinkTrackerController {

    private final ILinkTrackerService service;

    public LinkTrackerController(ILinkTrackerService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<IdLinkDTO> createLink(@RequestBody UrlLinkDTO urlDTO, @RequestParam String password){
        return new ResponseEntity<>(service.createLink(urlDTO, password), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirectLink(@PathVariable int id, @RequestParam String password){
        return new RedirectView(service.getLink(id, password));
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricsLinkDTO> getMetrics(@PathVariable Integer id){
        return new ResponseEntity<>(service.getMetrics(id), HttpStatus.OK);
    }

    @PostMapping("invalidate/{id}")
    public ResponseEntity<?> invalidate(@PathVariable Integer id){
        service.invalidateLink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
