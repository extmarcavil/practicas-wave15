package com.bootcamp.blog.repository;

import com.bootcamp.blog.dto.BlogDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository {
    Map<Integer, BlogDTO> entradas;

    public BlogRepository() {
        this.entradas = new HashMap<>();
    }

    public List<BlogDTO> getAll(){
        List<BlogDTO> listBlogs = new ArrayList<>(entradas.values());
        return listBlogs;
    }

    public BlogDTO createNewEntry(BlogDTO blog){
        BlogDTO existBlog = entradas.get(blog.getId());
        if (existBlog == null)
            entradas.put(blog.getId(),blog);
        return blog;
    }

}
