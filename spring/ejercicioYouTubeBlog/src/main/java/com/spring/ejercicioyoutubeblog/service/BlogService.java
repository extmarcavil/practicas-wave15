package com.spring.ejercicioyoutubeblog.service;

import com.spring.ejercicioyoutubeblog.dto.EntradaBlogDTO;
import com.spring.ejercicioyoutubeblog.model.EntradaBlog;
import com.spring.ejercicioyoutubeblog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepo;

    public BlogService(IBlogRepository blogRepo) {
        this.blogRepo = blogRepo;
    }

    @Override
    public Integer crearEntradaBlog(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog = new EntradaBlog();
        return blogRepo.crearEntradaBlog(EntradaBlog entradaBlog);
    }
}
