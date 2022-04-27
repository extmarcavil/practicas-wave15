package com.linkTracker.spring.Repository;

import com.linkTracker.spring.DTO.LinkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {
    int contador=4;
    List<LinkDTO> links;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public List<LinkDTO> getLinks() {
        return links;
    }

    public List<LinkDTO> getLinksById() {
        return links;
    }

    public void setLinks(List<LinkDTO> links) {
        this.links = links;
    }

    public LinkRepository() {
        links = crearLinks();
    }

    public void crearLink(String link) {
        LinkDTO aux= new LinkDTO(contador,link);
        this.contador++;
        links.add(aux);
    }

    public List<LinkDTO>crearLinks(){
        List<LinkDTO> list = new ArrayList<>();
        LinkDTO l1 = new LinkDTO(1,"www.google.com");
        LinkDTO l2 = new LinkDTO(2,"www.facebook.com");
        LinkDTO l3 = new LinkDTO(3,"www.twitter.com");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        return list;
    }




}
