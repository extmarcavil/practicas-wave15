package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.entity.EntradaBlog;
import com.blog.blog.exceptions.BlogDuplicadoException;
import com.blog.blog.exceptions.BlogNotFoundException;
import com.blog.blog.mapper.EntradaBlogMapper;
import com.blog.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements IEntradaBlogService{
    @Autowired
    IBlogRepository blogRepository;
    @Autowired
    EntradaBlogMapper entradaBlogMapper;

    @Override
    public EntradaBlogDTO crearBlog(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog1 = blogRepository.buscarBlogPorId(entradaBlogDTO.getId());
        if(!Objects.isNull(entradaBlog1)){
            throw new BlogDuplicadoException(); //Blog duplicado
        }
        EntradaBlog entradaBlog2 = blogRepository.crearBlog(entradaBlogMapper.entradaBlogDTOaEntradaBlog(entradaBlogDTO));
        return entradaBlogMapper.entradaBlogaEntradaBlogDTO(entradaBlog2);
    }

    @Override
    public EntradaBlogDTO buscarBlogPorId(Long id) {
        EntradaBlog entradaBlog = blogRepository.buscarBlogPorId(id);
        if(Objects.isNull(entradaBlog)){
           throw new BlogNotFoundException(); //No encontro el blog
        }
        return entradaBlogMapper.entradaBlogaEntradaBlogDTO(entradaBlog);
    }

    @Override
    public List<EntradaBlogDTO> listarBlogs() {
        return blogRepository.listarBlogs().stream().map(x -> entradaBlogMapper.entradaBlogaEntradaBlogDTO(x)).collect(Collectors.toList());
    }
}
