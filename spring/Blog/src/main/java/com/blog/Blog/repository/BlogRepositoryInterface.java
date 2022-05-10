package com.blog.Blog.repository;

import com.blog.Blog.model.Blog;

import java.util.List;

public interface BlogRepositoryInterface {

    void agregarEntrada(Blog entrada);
    boolean existeId(int idBlog);
    Blog obtenerEntrada(int entrada);
    List<Blog> obtenerEntradas();
}
