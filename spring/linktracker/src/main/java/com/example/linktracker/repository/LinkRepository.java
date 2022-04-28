package com.example.linktracker.repository;

import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LinkRepository implements ILinkRepository {
    /*private int index;
    private HashMap<Integer, Link> linkHashMap = new HashMap<>();*/

    // atributos
    private ArrayList<Link> links = new ArrayList<>();

    // metodos
    public int create(Link link){

        links.add(link);

        return links.size();
    }

    @Override
    public Link findByIndex(int index) {

        if(links.size() < index) return new Link();

        return links.get(index);
    }
}
