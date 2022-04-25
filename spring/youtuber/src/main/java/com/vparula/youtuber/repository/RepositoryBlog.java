package com.vparula.youtuber.repository;

import com.vparula.youtuber.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryBlog implements IRepositoryBlog {
    Map<Integer, EntradaBlog> blog = new HashMap<>();

    @Override
    public void agregarEntrada(EntradaBlog entrada){
        blog.put(entrada.getId(), entrada);
    }
    @Override
    public boolean existeId(int id){
        return blog.containsKey(id);
    }

    @Override
    public EntradaBlog obtenerEntrada(int entrada){
        return blog.get(entrada);
    }
    @Override
    public List<EntradaBlog> obtenerEntradas(){
        return new ArrayList<EntradaBlog>(blog.values());

    }
}
