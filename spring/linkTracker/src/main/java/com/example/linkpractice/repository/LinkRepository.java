package com.example.linkpractice.repository;

import com.example.linkpractice.models.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements IRepository {

    HashMap<Integer, Link> linkMap = new HashMap<Integer, Link>();
    static private Integer keyLinkMap = 1;


    @Override
    public Integer saveLink(Link link) {
        Integer key = keyLinkMap;
        linkMap.put(key, link);
        keyLinkMap += 1;
        return keyLinkMap;
    }

    @Override
    public Integer getVisits(String id) {
        return null;
    }

    @Override
    public void invalidate(String id) {

    }

    @Override
    public Link getLink(String id) {
        return null;
    }
}
