package com.Spring.LinkTracker.controller;


import com.Spring.LinkTracker.dto.LinkDTO;
import com.Spring.LinkTracker.service.ILinkService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

@RestController
@RequestMapping("/link/")
public class LinkController {

    ILinkService service;

    public LinkController(ILinkService service) {
        this.service = service;
    }

    @PostMapping("/{url}")
    public ResponseEntity<Integer> saveLink(@PathVariable String url){
        return new ResponseEntity<>(service.saveLink(url),HttpStatus.OK);
    }

    @GetMapping("/{idLink}")
    public RedirectView redirectUrl(@PathVariable Integer idLink){
        String link = "http://"+this.service.getURL(idLink);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(link);
        return redirectView;
    }




}
