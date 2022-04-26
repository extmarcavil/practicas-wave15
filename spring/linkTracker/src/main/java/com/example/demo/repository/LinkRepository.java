package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository {

    static int contador=0;
    Map<Integer,Link> links;

    public LinkRepository() {
        this.links = new HashMap<>();
    }

    public int addLink(Link link){
        contador++;
        link.setId(contador);
        links.put(contador,link);
        return contador;
    }

    public Link findURLByID(int id){
        return links.get(id);
    }

    public void incrementarEstadistica(Link link){
        link.setEstadistica(link.getEstadistica()+1);
    }
}
