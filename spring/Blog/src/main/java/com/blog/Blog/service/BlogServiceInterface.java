package com.blog.Blog.service;

import com.blog.Blog.dto.BlogDTO;

import java.util.List;

public interface BlogServiceInterface {

    void agregarBlog(BlogDTO blog);
    BlogDTO getEntrada(int entrada);
    List<BlogDTO> obtenerEntradas();


}
