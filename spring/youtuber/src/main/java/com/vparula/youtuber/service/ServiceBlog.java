package com.vparula.youtuber.service;

import com.vparula.youtuber.dto.EntradaDTO;
import com.vparula.youtuber.excepciones.BlogExisteException;
import com.vparula.youtuber.excepciones.NotFoundException;
import com.vparula.youtuber.model.EntradaBlog;
import com.vparula.youtuber.repository.IRepositoryBlog;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceBlog implements IServiceBlog {
    IRepositoryBlog repo;
    private ModelMapper mapper;

    public ServiceBlog(IRepositoryBlog repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();

    }

    @Override
    public void agregarBlog(EntradaBlog blog) {
        if(repo.existeId(blog.getId())){
            throw new BlogExisteException("Ya existe una entrada al blog con id: " + blog.getId());
        }
        repo.agregarEntrada(blog);
    }

    @Override
    public EntradaDTO getEntrada(int entrada) {
        if (!repo.existeId(entrada))
            throw new NotFoundException("No existe una entrada al blog con id: " + entrada);
        EntradaBlog entradaB = repo.obtenerEntrada(entrada);
        return mapper.map(entradaB, EntradaDTO.class);
    }

    @Override
    public List<EntradaDTO> obtenerEntradas(){
        List<EntradaBlog> blog = repo.obtenerEntradas();
        List<EntradaDTO> blogDTO = new ArrayList<>();
        if(blog ==null || blog.size()==0) {
            throw new NotFoundException("El blog no tiene entradas");
        }
        blogDTO = blog.stream().map(ing -> mapper.map(ing, EntradaDTO.class)).collect(Collectors.toList());
        return blogDTO;

    }


}
