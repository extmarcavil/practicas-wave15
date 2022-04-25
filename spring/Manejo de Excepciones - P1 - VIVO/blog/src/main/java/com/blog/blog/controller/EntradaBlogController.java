package com.blog.blog.controller;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntradaBlogController implements IEntradaBlogController{
    @Autowired
    IEntradaBlogService entradaBlogService;

    @Override
    public EntradaBlogDTO crearBlog(EntradaBlogDTO entradaBlogDTO) {
        return entradaBlogService.crearBlog(entradaBlogDTO);
    }

    @Override
    public EntradaBlogDTO buscarBlogPorId(Long id) {
        return entradaBlogService.buscarBlogPorId(id);
    }

    @Override
    public List<EntradaBlogDTO> listarBlogs() {
        return entradaBlogService.listarBlogs();
    }
}
