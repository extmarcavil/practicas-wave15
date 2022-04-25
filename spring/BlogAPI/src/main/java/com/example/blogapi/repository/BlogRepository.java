package com.example.blogapi.repository;

import com.example.blogapi.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BlogRepository {

    HashMap<Integer, EntradaBlog> entradasBlog = new HashMap<>();

}
