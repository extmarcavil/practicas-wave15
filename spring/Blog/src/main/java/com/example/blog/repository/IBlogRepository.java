package com.example.blog.repository;

import com.example.blog.DTO.BlogDTO;

import java.util.List;

public interface IBlogRepository {

    Integer saveBlog(String title, String name);
    BlogDTO blogInfo(Integer id);
    boolean checkIfExist(Integer id);
    List<BlogDTO> getBlogList();

}
