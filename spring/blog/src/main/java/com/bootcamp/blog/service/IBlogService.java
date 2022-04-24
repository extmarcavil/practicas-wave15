package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogService {

    EntradaBlogDTO makeEntrada(Integer id, String name, String autor, String date);
    EntradaBlogDTO findById(Integer id);
    List<EntradaBlogDTO> allEntradas();
}
