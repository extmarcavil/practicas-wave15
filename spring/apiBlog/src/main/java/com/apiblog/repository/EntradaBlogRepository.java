package com.apiblog.repository;

import com.apiblog.exceptions.EntradaBlogDuplicadaException;
import com.apiblog.exceptions.EntradaBlogNoEncontradaException;
import com.apiblog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    //region Variables
    private List<EntradaBlog> listEntradaBlog;
    //endregion

    //region Constructor Publico

    public EntradaBlogRepository() {
        listEntradaBlog = new ArrayList<>();
    }

    //endregion

    //region Implementacion

    @Override
    public List<EntradaBlog> getAll() {
        return listEntradaBlog;
    }

    @Override
    public Integer add(EntradaBlog entrada) {
        existeId(entrada.getId());
        listEntradaBlog.add(entrada);
        return entrada.getId();
    }

    @Override
    public EntradaBlog findById(int Id) {
        var blog = listEntradaBlog.stream()
                .filter(f ->
                        f.getId() == Id).findFirst();
        if(blog.isPresent())
            return  blog.get();
        else
            throw new EntradaBlogNoEncontradaException();
    }

    //endregion

    //region Privados
    private  void existeId(int Id){
     var listFilter = listEntradaBlog.stream()
                        .filter(f->
                        f.getId() == Id).collect(Collectors.toList());
       if(listFilter.size() > 0)
           throw  new EntradaBlogDuplicadaException();

    }
    //endregion
}
