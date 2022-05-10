package com.example.linktracker.repository;

import com.example.linktracker.models.Link;

public interface LinkRepository {

    Integer save(Link link);
    Link getLink(Integer id);
    void invalidate(Integer id);
}
