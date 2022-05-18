package com.example.blog.repository;

import com.example.blog.DTO.BlogDTO;
import com.example.blog.exception.IdNotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements  IBlogRepository{

    List<BlogDTO> blogList;

    public BlogRepository(){
        this.blogList = new ArrayList<>();
    }

    //Devuelve la lista con los blogs
    public List<BlogDTO> getBlogList() {
        return blogList;
    }

    //Recibe el titulo y autor de la entrada y crea una instancia de un BlogDTO. Lo almacena en una
    // list y devuelve el ID.
    @Override
    public Integer saveBlog(String title, String name) {
        BlogDTO blogDTO = new BlogDTO(blogList.size(), title, name, LocalDate.now());
        blogList.add(blogDTO);
        return blogDTO.getId();
    }

    //Hace un stream por la lista con los BlogDTO y filtra por ID. Si encuentra la entrada deseada, la devuelve
    // sino, devuelve null.
    @Override
    public BlogDTO blogInfo(Integer id) {
        return blogList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean checkIfExist(Integer id) {
        BlogDTO search = blogInfo(id);
        return search != null;
    }
}
