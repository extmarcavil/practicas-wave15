package com.example.linkpractice.repository;

import com.example.linkpractice.exceptions.NotFoundException;
import com.example.linkpractice.models.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements IRepository {

    static HashMap<Integer, Link> linkMap = new HashMap<Integer, Link>();
    static private Integer keyLinkMap = 1;


    @Override
    public Integer saveLink(Link link) {
        Integer key = keyLinkMap;
        linkMap.put(key, link);
        keyLinkMap += 1;
        return key;
    }

    @Override
    public Integer getVisits(String id) {
        return null;
    }

    @Override
    public void invalidate(String id) {

    }

    @Override
    public String getLink(Integer id) {
        String link;
        try{
            link = linkMap.get(id).getLink();
        } catch (Exception e) {
            throw new NotFoundException("No se encontró link con el ID " + id);
        }

        return link;
    }
}
