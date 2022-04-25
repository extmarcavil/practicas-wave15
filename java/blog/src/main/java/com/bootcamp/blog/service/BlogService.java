package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.ResponseBlogDTO;
import com.bootcamp.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    IBlogRepository repository;

    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    public ResponseBlogDTO createNewEntry(BlogDTO blog){
        ResponseBlogDTO response = new ResponseBlogDTO()
    }
}
