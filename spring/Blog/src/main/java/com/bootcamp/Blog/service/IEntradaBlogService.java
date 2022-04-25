package com.bootcamp.Blog.service;

import com.bootcamp.Blog.dto.EntradaBlogDTO;

import java.util.List;


public interface IEntradaBlogService {

    List<EntradaBlogDTO> getAllBlogEntriesDTO();
    EntradaBlogDTO getBlogEntriesByNameDTO(Integer id);
    String postBlogEntry( EntradaBlogDTO eb);
}

