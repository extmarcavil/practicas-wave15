package com.linkTracker.spring.Repository;

import com.linkTracker.spring.DTO.LinkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {
    int contador=0;
    List<LinkDTO> links;

    public LinkRepository() {
        links = new ArrayList<>();
    }

    public LinkDTO crearLink(String link) {
        LinkDTO aux= new LinkDTO(contador,link);
        this.contador++;
        links.add(aux);

        return aux;
    }


}
