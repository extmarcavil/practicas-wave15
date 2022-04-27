package com.linkTracker.spring.Controller;

import com.linkTracker.spring.DTO.LinkDTO;
import com.linkTracker.spring.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("crear/{link}")
    public Integer crearLink(@PathVariable String link){

        LinkDTO linkDTO=linkService.createLink(link);

        return linkDTO.getId();




    }


    @PostMapping("link/{linkId")
    public String redireccionador(String linkId){
        return 
    }




}
