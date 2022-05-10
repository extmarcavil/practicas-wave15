package com.example.linktracker.repository;

import com.example.linktracker.models.Link;
import org.springframework.stereotype.Repository;

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
    public Integer save(Link link) {
        links.put(++nextId, link);
        return nextId;
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
