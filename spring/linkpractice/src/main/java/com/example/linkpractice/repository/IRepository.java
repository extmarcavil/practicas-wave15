package com.example.linkpractice.repository;
import com.example.linkpractice.models.Link;

public interface IRepository {
    public Integer saveLink(Link link);
    public Link getLink(Integer id);
}
