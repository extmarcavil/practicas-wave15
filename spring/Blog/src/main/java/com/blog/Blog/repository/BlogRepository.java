package com.blog.Blog.repository;

import com.blog.Blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository implements BlogRepositoryInterface {

    Map<Integer, Blog> blog = new HashMap<>();

    @Override
    public void agregarEntrada(Blog entrada) {
        blog.put(entrada.getIdBlog(), entrada);
    }

    @Override
    public boolean existeId(int idBlog) {
        return blog.containsKey(idBlog);
    }

    @Override
    public Blog obtenerEntrada(int entrada) {
        return blog.get(entrada);
    }

    @Override
    public List<Blog> obtenerEntradas() {
        return new ArrayList<>(blog.values());
    }
}
