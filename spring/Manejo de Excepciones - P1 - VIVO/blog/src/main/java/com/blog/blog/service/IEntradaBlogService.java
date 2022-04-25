package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDTO;
import java.util.List;

public interface IEntradaBlogService {
    public EntradaBlogDTO crearBlog(EntradaBlogDTO entradaBlog);

    public EntradaBlogDTO buscarBlogPorId(Long id);

    public List<EntradaBlogDTO> listarBlogs();
}
