package com.spring.ejercicioyoutubeblog.repository;

import com.spring.ejercicioyoutubeblog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {

    private List<EntradaBlog> entradas;


    @Override
    public Integer crearEntradaBlog(EntradaBlog entradaBlog) {
        return null;
    }
}
