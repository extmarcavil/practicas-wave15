package com.example.blogpractica.Repository;

import com.example.blogpractica.Entity.EntradaBlog;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    List<EntradaBlog> blogs;

    public BlogRepositoryImpl() {
        this.blogs = blogs;
        initBlog();
    }


    public void initBlog() {
        this.blogs = new ArrayList<>();
        blogs.add(new EntradaBlog(1, "memorias", "Pedro pablo l", LocalDate.of(2021, 1, 1)));
        blogs.add(new EntradaBlog(2, "memorias1", "Pedro pablo f", LocalDate.of(2011, 1, 1)));
        blogs.add(new EntradaBlog(3, "memorias2", "Pedro pablo d", LocalDate.of(2002, 1, 1)));
        blogs.add(new EntradaBlog(4, "memorias3", "Pedro pablo t", LocalDate.of(2004, 1, 1)));
        blogs.add(new EntradaBlog(5, "memorias4", "Pedro pablo c", LocalDate.of(2020, 1, 1)));
        blogs.add(new EntradaBlog(6, "memorias5", "Pedro pablo s", LocalDate.of(2022, 1, 1)));
        blogs.add(new EntradaBlog(7, "memorias6", "Pedro pablo p", LocalDate.of(2003, 1, 1)));
        blogs.add(new EntradaBlog(8, "memorias7", "Pedro pablo o", LocalDate.of(2005, 1, 1)));

    }

    @Override
    public ResponseEntity<?> crearBlog(Integer id, String tituloBlog, String autorBlog, LocalDate fechaPublicacion) {

        ResponseEntity<?> responseEntity = null;
        EntradaBlog entradaBlog = new EntradaBlog();

        if (existeBlog(id)) {
            return responseEntity = ResponseEntity.badRequest().body("El blog con el id: " + id + ", ya existe");
        }

        entradaBlog.setIdBlog(id);
        entradaBlog.setTítuloBlog(tituloBlog);
        entradaBlog.setNombreAutor(autorBlog);
        entradaBlog.setFechaPublicacion(fechaPublicacion);

        this.blogs.add(entradaBlog);
        responseEntity = ResponseEntity.ok().body("El blog con el id: " + id + ", se ha creado correctamente");


        return responseEntity;

    }

    @Override
    public ResponseEntity<?> findEntradaBlogById(int id) {

        ResponseEntity responseEntity = null;

        EntradaBlog entradaBlog = this.blogs.stream()
                .filter(blog -> blog.getIdBlog() == id)
                .findAny().orElse(null);

        if (entradaBlog == null) {
            return responseEntity = ResponseEntity.badRequest().body("El blog con el id: " + id + ", no existe");
        } else {
            responseEntity = ResponseEntity.ok(entradaBlog);
        }

        return responseEntity;
    }

    @Override
    public List<EntradaBlog> findAll() {
        return this.blogs;
    }

    public boolean existeBlog(int id) {
        return this.blogs.stream()
                .anyMatch(blog -> blog.getIdBlog() == id);
    }
}
