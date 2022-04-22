package com.youtuber.exception.service;

import com.youtuber.exception.dto.BlogDTO;
import com.youtuber.exception.dto.BlogIdDTO;
import com.youtuber.exception.entity.EntradaBlogEntity;
import com.youtuber.exception.exception.IdExistException;
import com.youtuber.exception.exception.IdNotFoundException;
import com.youtuber.exception.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public BlogIdDTO saveBlogEntry(EntradaBlogEntity entry) throws IdExistException {
        BlogDTO newEntry = new BlogDTO();

        if (blogRepository.existId(entry.getId()))
            throw new IdExistException("El id #" + entry.getId() + " ingresado, ya existe");

        newEntry.setTitulo(entry.getTitulo());
        newEntry.setAutor(entry.getAutor());
        newEntry.setFechaPublicacion(entry.getFechaPublicacion());

        return blogRepository.save(entry.getId(), newEntry);
    }

    public BlogDTO getBlog(Integer id) throws IdNotFoundException {
        BlogDTO entry = blogRepository.findById(id);

        if (entry == null)
            throw new IdNotFoundException("No se encontró el blog con el id #" + id);

        return entry;
    }

    public Map<Integer, BlogDTO> getBlogs() {
        return blogRepository.findAll();
    }
}
