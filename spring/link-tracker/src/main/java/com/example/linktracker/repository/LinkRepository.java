package com.example.linktracker.repository;

import com.example.linktracker.models.Link;

import java.net.URL;

public interface LinkRepository {
    Integer save(URL url, String password);
    Link getLink(Integer id, boolean increment);
    void invalidate(Integer id);
}
