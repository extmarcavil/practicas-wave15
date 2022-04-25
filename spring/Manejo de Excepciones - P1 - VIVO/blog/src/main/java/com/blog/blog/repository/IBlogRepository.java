package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;
import java.util.List;

public interface IBlogRepository {
    public EntradaBlog crearBlog(EntradaBlog entradaBlog);

    public EntradaBlog buscarBlogPorId(Long id);

    public List<EntradaBlog> listarBlogs();
}
