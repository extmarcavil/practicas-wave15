package com.bootcamp.blog.repository;

import com.bootcamp.blog.exceptions.AlreadyExistsException;
import com.bootcamp.blog.exceptions.NotFoundException;
import com.bootcamp.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    private HashMap<Long, EntradaBlog> blog;

    public BlogRepository(){
        this.blog = new HashMap<>();
    }

    @Override
    public Long crearBlog(EntradaBlog entradaBlog) {

        if(blog.containsKey(entradaBlog.getId())){
            throw new AlreadyExistsException("Ya existe el recurso.");
        }

        blog.put(entradaBlog.getId(), entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public EntradaBlog buscarPorId(Long id) {
         EntradaBlog entradaBlog = blog.get(id);
         if(entradaBlog == null){
             throw new NotFoundException("No se encontro la entrada con el id: " + id );
         }

         return entradaBlog;
    }

    @Override
    public List<EntradaBlog> buscarTodos() {
        return new ArrayList<>(blog.values());
    }
}
