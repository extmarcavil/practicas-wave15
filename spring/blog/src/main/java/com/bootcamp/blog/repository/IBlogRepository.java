package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Optional<EntradaBlog> findEntradaBlogById(Integer id);
    //void addOneBlog(Integer id, String name, String autor, String date);
    void addOneBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> getDatabase();
}
