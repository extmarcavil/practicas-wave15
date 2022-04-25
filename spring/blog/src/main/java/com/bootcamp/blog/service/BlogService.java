package com.bootcamp.blog.service;

import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repository.IBlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BlogService implements IBlogService{

    private IBlogRepository blogRepository;

    @Override
    public Long crearBlog(EntradaBlog entradaBlog) {
        return blogRepository.crearBlog(entradaBlog);
    }

    @Override
    public EntradaBlog buscarPorId(Long id) {
        return blogRepository.buscarPorId(id);
    }

    @Override
    public List<EntradaBlog> buscarTodos() {
        return blogRepository.buscarTodos();
    }
}
