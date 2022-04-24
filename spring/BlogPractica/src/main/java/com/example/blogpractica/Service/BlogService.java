package com.example.blogpractica.Service;

import com.example.blogpractica.Entity.EntradaBlog;
import com.example.blogpractica.Repository.IBlogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {

    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public ResponseEntity<?> crearBlog(Integer id, String tituloBlog, String autorBlog, LocalDate fechaPublicacion) {
        return blogRepository.crearBlog(id, tituloBlog, autorBlog, fechaPublicacion);
    }


    public List<EntradaBlog> listarBlogs() {
        return blogRepository.findAll();
    }

    public ResponseEntity<?> getBlog(int id) {
        return blogRepository.findEntradaBlogById(id);
    }


}
