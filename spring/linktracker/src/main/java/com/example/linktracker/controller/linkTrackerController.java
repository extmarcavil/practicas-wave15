package com.example.linktracker.controller;

import com.example.linktracker.dto.RequestLinkDTO;
import com.example.linktracker.dto.ResponseLinkDTO;
import com.example.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class linkTrackerController {
    // atributos
    private ILinkService linkService;

    // constructor
    public linkTrackerController(ILinkService linkService) {
        this.linkService = linkService;
    }

    // endpoints
    @PostMapping("/link")
    public /*ResponseEntity<ResponseLinkDTO>*/ RequestLinkDTO createLink(@RequestBody RequestLinkDTO valor){ // dto solo link
        // ResponseLinkDTO responseLinkDTO =  linkService.create(url);
        return valor;
        // return new ResponseEntity<>(responseLinkDTO, HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable String linkId){
        String respReq =  linkService.findByIndex(Integer.parseInt(linkId));

        return new RedirectView(respReq);
    }
}
