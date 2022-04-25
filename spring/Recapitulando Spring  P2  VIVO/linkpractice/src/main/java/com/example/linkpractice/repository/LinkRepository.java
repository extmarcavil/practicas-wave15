package com.example.linkpractice.repository;

import com.example.linkpractice.models.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements IRepository {

    HashMap<Integer, Link> links;


    @Override
    public Integer saveLink(Link link) {
        return null;
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
