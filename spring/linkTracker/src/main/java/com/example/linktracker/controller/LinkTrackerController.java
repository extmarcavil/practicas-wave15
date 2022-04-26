package com.example.linktracker.controller;

import com.example.linktracker.DTO.LinkDTO;
import com.example.linktracker.service.ILinkService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

import java.util.List;

@RestController
public class LinkTrackerController {
    ILinkService linkService;
    HttpHeaders headers = new HttpHeaders();

    public LinkTrackerController( ILinkService linkService){
        this.linkService=linkService;
    }

    @PostMapping("/link")
    public Integer crearLink(@RequestBody LinkDTO dto){
        return linkService.saveLink(dto);
    }
    @GetMapping("/links")
    public List<LinkDTO> mostrarLinks(){
        return linkService.mostrarLinks();
    }
    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable Integer id){

        return new RedirectView(linkService.getUrlFromId(id));
    }

}
