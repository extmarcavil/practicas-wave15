package com.bootcamp.blog.service;

import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogService {
    Long crearBlog(EntradaBlog entradaBlog);
    EntradaBlog buscarPorId(Long id);
    List<EntradaBlog> buscarTodos();
}
