package com.blog.blog.controller;

import com.blog.blog.dto.EntradaBlogDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface IEntradaBlogController {
    @PostMapping("/blog")
    public EntradaBlogDTO crearBlog(@RequestBody EntradaBlogDTO entradaBlogDTO);

    @PostMapping("/blog/{idBlog}")
    public EntradaBlogDTO buscarBlogPorId(@RequestBody Long id);

    @PostMapping("/listarBlogs")
    public List<EntradaBlogDTO> listarBlogs();
}
