package com.youtuber.exception.repository;

import com.youtuber.exception.dto.BlogDTO;
import com.youtuber.exception.dto.BlogIdDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepository {

    private Map<Integer, BlogDTO> blog;


    public BlogRepository() {
        blog = new HashMap<>();
    }


    public Map<Integer, BlogDTO> findAll() {
        return blog;
    }

    public BlogDTO findById(Integer id) {
        return blog.get(id);
    }

    public BlogIdDTO save(Integer id, BlogDTO entry) {
        blog.put(id, entry);
        return new BlogIdDTO(id);
    }

    public boolean existId(Integer id) {
        return blog.containsKey(id);
    }

}
