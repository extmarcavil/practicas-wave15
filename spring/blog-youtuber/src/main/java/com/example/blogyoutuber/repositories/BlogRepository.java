package com.example.blogyoutuber.repositories;

import com.example.blogyoutuber.models.Blog;

import java.util.List;

public interface BlogRepository {
    Blog save(Blog blog);
    List<Blog> getAll();
    Blog get(Integer id);
}
