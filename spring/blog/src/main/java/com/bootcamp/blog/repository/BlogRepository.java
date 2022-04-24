package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Repository
public class BlogRepository implements IBlogRepository {
    List<EntradaBlog> database;

    public BlogRepository(){
        this.database = new ArrayList<>();
        addBlog();
    }

    public void addBlog(){
        database.add(new EntradaBlog(1,"Omicron","OMS","2000,12,20"));
        database.add(new EntradaBlog(2,"Omicron1","OMSsss","2010,10,20"));
        database.add(new EntradaBlog(3,"Omicron2","OMSddd","2020,12,20"));
        database.add(new EntradaBlog(4,"Omicron3","OMSfff","2018,12,20"));
    }

    @Override
    public Optional<EntradaBlog> findEntradaBlogById(Integer id){
        return database.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public void addOneBlog(EntradaBlog entradaBlog){
       // database.add(new EntradaBlog(id, name, autor, date));
        database.add(entradaBlog);
    }

    @Override
    public List<EntradaBlog> getDatabase() {
        return database;
    }
}
