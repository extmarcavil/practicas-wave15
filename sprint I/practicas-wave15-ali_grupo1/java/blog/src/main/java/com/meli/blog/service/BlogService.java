package com.meli.blog.service;

import com.meli.blog.dto.BlogDto;
import com.meli.blog.dto.SuccessDto;
import com.meli.blog.exceptions.BlogAlreadyExistsException;
import com.meli.blog.exceptions.BlogDoesNotExistException;
import com.meli.blog.model.Blog;
import com.meli.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogDto findById(Long id) {
        return blogRepository.findById(id)
                .map(BlogDto::from)
                .orElseThrow(() -> new BlogDoesNotExistException(id));
    }

    public List<BlogDto> findAll() {
        return blogRepository.findAll().stream()
                .map(BlogDto::from)
                .collect(Collectors.toList());
    }

    public ResponseEntity<SuccessDto> create(Blog blog) {
        if (blogRepository.existsById(blog.getId())) {
            throw new BlogAlreadyExistsException(blog);
        }
        blogRepository.save(blog);
        return createResponseFrom(blog);
    }

    private ResponseEntity<SuccessDto> createResponseFrom(Blog blog) {
        return new ResponseEntity<>(SuccessDto.from(blog), HttpStatus.CREATED);
    }

}
