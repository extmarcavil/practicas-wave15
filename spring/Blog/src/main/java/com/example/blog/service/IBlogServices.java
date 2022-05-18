package com.example.blog.service;

import com.example.blog.DTO.BlogDTO;

import java.util.List;

public interface IBlogServices {

    Integer newBlog(String title, String name);
    BlogDTO getBlogInformation(Integer id);
    List<BlogDTO> getAllBlogs();

}
