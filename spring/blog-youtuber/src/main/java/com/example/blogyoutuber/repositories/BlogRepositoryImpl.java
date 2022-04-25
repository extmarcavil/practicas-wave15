package com.example.blogyoutuber.repositories;

import com.example.blogyoutuber.models.Blog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    private List<Blog> blogs;

    public BlogRepositoryImpl() {

    }

    public List<Blog> blogs(){
        blogs = new ArrayList<>(Arrays.asList(
                new Blog(1, "Primer articulo", "Pablo Perez", LocalDate.now()),
                new Blog(2, "Segundo articulo", "Pablo Perez", LocalDate.now())
        ));
        return blogs;
    }

    @Override
    public Blog save(Blog blog) {
        List<Blog> blogs1 = this.blogs();
        blogs1.add(blog);
        return blog;
    }

    @Override
    public List<Blog> getAll() {
        return blogs();
    }

    @Override
    public Blog getById(Integer id) {
        return blogs().stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst()
                .orElse(null)
                ;
    }

    @Override
    public Boolean getBooleanId(Integer id) {
        Boolean bandera = false;
        Blog blog = blogs.stream()
                .filter(blog1 -> blog1.getId().equals(id))
                .findFirst()
                .orElse(null)
                ;
        if (blog != null) {
            bandera = true;
        }
        return bandera;
    }
}
