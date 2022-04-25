package com.linkTracker.spring.Controller;

import com.linkTracker.spring.DTO.LinkDTO;
import com.linkTracker.spring.DTO.ResponseLinkDTO;
import com.linkTracker.spring.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkController {

    LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("crear/{link}")
    public ResponseEntity<List<LinkDTO>> crearLink(@PathVariable String link){
        return new ResponseEntity<>(linkService.cargarLink(link), HttpStatus.OK);

    }


//    @PostMapping("link/{linkId}")
//    public String redireccionador(String linkId){
//        return  null;
//    }




}
