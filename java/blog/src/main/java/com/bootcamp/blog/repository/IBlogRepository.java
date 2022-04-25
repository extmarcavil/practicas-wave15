package com.bootcamp.blog.repository;

import com.bootcamp.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogRepository {
    List<BlogDTO> getAll();
}
