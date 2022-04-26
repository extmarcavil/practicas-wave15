package com.example.linkpractice.repository;

import com.example.linkpractice.models.Link;

public interface IRepository {

    public Integer saveLink(Link link);
    public Integer getVisits(String id);
    public void invalidate(String id);
    public String getLink(Integer id);
}
