package com.example.blogyoutuber.services;

import com.example.blogyoutuber.exceptions.BlogNotFoundException;
import com.example.blogyoutuber.models.Blog;
import com.example.blogyoutuber.repositories.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    @Override
    public List<Blog> getAll() {
        return blogRepository.getAll();
    }

    @Override
    public Blog getBlog(Integer id) {
        return blogRepository.getAll()
                .stream()
                .filter( blog ->  blog.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BlogNotFoundException("No se pudo encontrar el Blog"));
    }



    @Override
    public Blog save(Blog blog) {
        String message = "";
        if (blog.getId() == null ){
                  message = String.format("No se puede agregar el Blog dado que tiene el id null : " + blog.getId());

                  throw new BlogNotFoundException(message);
        }
        blogRepository.save(blog);
        return blog;

    }


}
