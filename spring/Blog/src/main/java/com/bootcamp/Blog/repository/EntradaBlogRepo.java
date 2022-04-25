package com.bootcamp.Blog.repository;

import com.bootcamp.Blog.model.EntradaBlog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EntradaBlogRepo implements IEntradaBlogRepo {

    private final List<EntradaBlog> repositorio;

    public EntradaBlogRepo(){
        repositorio = new ArrayList<>();
        initData();
    }

    @Override
    public List<EntradaBlog> getAllBlogEntries() {return this.repositorio;}

    @Override
    public EntradaBlog getBlogEntryById(Integer id){
        return this.repositorio.stream()
                .filter(eb -> eb.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void addBlogEntry(EntradaBlog eb) {this.repositorio.add(eb);}

    private void initData(){
        LocalDate hoy = LocalDate.now();

        EntradaBlog eb1 = new EntradaBlog(1,"Como hacer un hola mundo", "Martin Bermudez", LocalDate.parse("2020-01-08"));
        EntradaBlog eb2 = new EntradaBlog(2,"Como instanciar un objeto", "Jose Alvarado", LocalDate.parse("2022-04-18"));
        EntradaBlog eb3 = new EntradaBlog(3,"Inyeccion de dependencias en Spring", "Martin Bermudez", hoy);

        repositorio.addAll(Arrays.asList(eb1,eb2,eb3));
    }
}
