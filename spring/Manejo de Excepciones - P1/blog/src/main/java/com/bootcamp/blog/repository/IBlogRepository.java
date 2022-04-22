package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    Long crearBlog(EntradaBlog entradaBlog);
    EntradaBlog buscarPorId(Long id);
    List<EntradaBlog> buscarTodos();
}
