package com.example.linktracker.repository;

import com.example.linktracker.models.Link;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements LinkRepository {
    private final Map<Integer, Link> links;
    private Integer nextId;

    public LinkRepositoryImpl() {
        links = new HashMap<>();
        nextId = 1;
    }

    @Override
    public Integer save(URL url, String password) {
        Link link = new Link(nextId, url, password);
        links.put(nextId, link);
        nextId++;
        return link.getId();
    }

    @Override
    public Link getLink(Integer id) {
        return links.get(id);
    }

    @Override
    public void invalidate(Integer id) {
        links.remove(id);
    }
}
