package com.example.blog.service;

import com.example.blog.DTO.BlogDTO;
import com.example.blog.exception.BlogAlreadyExists;
import com.example.blog.exception.IdNotFoundException;
import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServices implements IBlogServices{

    IBlogRepository repo;

    public BlogServices(IBlogRepository repo){
        this.repo = repo;
    }

    @Override
    public Integer newBlog(String title, String name) {
        if(repo.checkIfExist(repo.getBlogList().size())) throw new BlogAlreadyExists(repo.getBlogList().size());
        return repo.saveBlog(title, name);
    }

    @Override
    public BlogDTO getBlogInformation(Integer id) {
        BlogDTO blog = repo.blogInfo(id);
        if (blog == null) throw new IdNotFoundException(id);
        else return blog;
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        return repo.getBlogList();
    }
}
