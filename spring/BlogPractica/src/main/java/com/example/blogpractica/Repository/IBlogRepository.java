package com.example.blogpractica.Repository;

import com.example.blogpractica.Entity.EntradaBlog;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IBlogRepository {

    ResponseEntity<?> crearBlog(Integer id, String tituloBlog, String autorBlog, LocalDate fechaPublicacion);

    ResponseEntity<?> findEntradaBlogById(int id);

    List<EntradaBlog> findAll();
}
