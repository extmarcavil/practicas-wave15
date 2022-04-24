package com.example.blogpractica.Controller;

import com.example.blogpractica.Entity.EntradaBlog;
import com.example.blogpractica.Service.BlogService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/blog")
    public ResponseEntity<?> createBlog(@RequestBody EntradaBlog entradaBlog) {

        return blogService.crearBlog(entradaBlog.getIdBlog(), entradaBlog.getTítuloBlog(), entradaBlog.getNombreAutor(), entradaBlog.getFechaPublicacion());
    }

    @GetMapping("/blogs")
    public List<EntradaBlog> getBlogs() {
        return blogService.listarBlogs();
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlog(@PathVariable int id) {
        return blogService.getBlog(id);
    }
}
