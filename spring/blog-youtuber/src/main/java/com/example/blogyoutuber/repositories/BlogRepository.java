package com.example.blogyoutuber.repositories;

import com.example.blogyoutuber.models.Blog;

import java.util.List;

public interface BlogRepository {
    Blog save(Blog blog);
    List<Blog> getAll();
    Blog getById(Integer id);

    Boolean getBooleanId(Integer id);
}
