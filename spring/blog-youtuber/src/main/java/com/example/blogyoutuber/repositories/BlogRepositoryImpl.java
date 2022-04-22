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
        blogs = new ArrayList<>(Arrays.asList(
                new Blog(1, "Primer articulo", "Pablo Perez", LocalDate.now()),
                new Blog(2, "Segundo articulo", "Pablo Perez", LocalDate.now())
        ));
    }

    @Override
    public Blog save(Blog blog) {
        blogs.add(blog);
        return blog;
    }

    @Override
    public List<Blog> getAll() {
        return blogs;
    }

    @Override
    public Blog get(Integer id) {
        return blogs.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst()
                .orElse(null)
                ;
    }
}
