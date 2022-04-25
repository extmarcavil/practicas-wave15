package com.example.blogyoutuber.services;

import com.example.blogyoutuber.exceptions.BlogNotFoundException;
import com.example.blogyoutuber.models.Blog;
import com.example.blogyoutuber.repositories.BlogRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepositoryImpl blogRepository;

    public BlogServiceImpl(BlogRepositoryImpl blogRepository) {

        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.getAll();
    }

    @Override
    public Blog getBlog(Integer id) {

        Blog blog = blogRepository.getById(id);
        if (!blogRepository.getBooleanId(id)){
            throw new BlogNotFoundException("El ID: " + id + " del blog NO existe");
        }

        return blog;
    }

    @Override
    public Blog save(Blog blog) {

        if (blogRepository.getBooleanId(blog.getId())){
            throw new BlogNotFoundException("El ID del blog ya existe");
        }else {
            blogRepository.save(blog);
        }
        System.out.println(getAll());
        return blog;
    }

}
