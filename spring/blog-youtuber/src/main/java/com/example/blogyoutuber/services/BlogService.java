package com.example.blogyoutuber.services;

import com.example.blogyoutuber.models.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAll();
    Blog getBlog(Integer id);
    Blog save(Blog blog);
}
