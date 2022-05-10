package com.blog.Blog.service;

import com.blog.Blog.dto.BlogDTO;
import com.blog.Blog.exceptions.BlogExisteException;
import com.blog.Blog.exceptions.NotFoundException;
import com.blog.Blog.model.Blog;
import com.blog.Blog.repository.BlogRepositoryInterface;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements BlogServiceInterface {
    BlogRepositoryInterface blogRepositoryInterface;
    ModelMapper mapper;

    public BlogService(BlogRepositoryInterface blogRepositoryInterface) {
        this.blogRepositoryInterface = blogRepositoryInterface;
        this.mapper = new ModelMapper();
    }

    @Override
    public void agregarBlog(BlogDTO blog) {
        if(blogRepositoryInterface.existeId(blog.getIdBlog())){
            throw new BlogExisteException("Ya existe una entrada al blog con id: " + blog.getIdBlog());
        }
        Blog entrada = mapper.map(blog,Blog.class);
        blogRepositoryInterface.agregarEntrada(entrada);
    }

    @Override
    public BlogDTO getEntrada(int entrada) {
        if (!blogRepositoryInterface.existeId(entrada))
            throw new NotFoundException("No existe una entrada al blog con id: " + entrada);
        Blog entradaObtenida = blogRepositoryInterface.obtenerEntrada(entrada);
        return mapper.map(entradaObtenida, BlogDTO.class);
    }

    @Override
    public List<BlogDTO> obtenerEntradas() {
        List<Blog> blog = blogRepositoryInterface.obtenerEntradas();
        List<BlogDTO> blogDTO;
        if(blog == null || blog.size() == 0) {
            throw new NotFoundException("El blog no tiene entradas");
        }
        blogDTO = blog.stream().map(ing -> mapper.map(ing, BlogDTO.class)).collect(Collectors.toList());
        return blogDTO;
    }
}
