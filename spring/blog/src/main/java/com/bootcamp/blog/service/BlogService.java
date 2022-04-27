package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.exception.ExistingBlockEntranceException;
import com.bootcamp.blog.exception.NoFoudBlogException;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repository.IBlogRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository blogRepository;

    ModelMapper mapper = new ModelMapper();

    public boolean existingEntrada ( Integer id){
        boolean existe = false;
        if(blogRepository.findEntradaBlogById(id).isPresent()) {existe = true;}
        return existe;
    }

    @Override
    public EntradaBlogDTO makeEntrada(Integer id, String name, String autor, String date) {
        EntradaBlog entradaBlog;

        if (!existingEntrada(id)) {
            entradaBlog = new EntradaBlog(id,name,autor,date);
            blogRepository.addOneBlog(entradaBlog);
        }else{
            throw new ExistingBlockEntranceException("El id ingresado ya existe");
        }
        return mapper.map(entradaBlog,EntradaBlogDTO.class);
    }

    @Override
    public EntradaBlogDTO findById(Integer id){
        return mapper.map(blogRepository
                .findEntradaBlogById(id)
                .stream()
                .findFirst()
                .orElseThrow(() ->new NoFoudBlogException("El blog con id " + id + " no se encontro"))
                ,EntradaBlogDTO.class);
    }

    @Override
    public List<EntradaBlogDTO> allEntradas(){
        return blogRepository.getDatabase().stream()
                .map(entradaBlog -> mapper.map(entradaBlog,EntradaBlogDTO.class))
                .collect(Collectors.toList());
    }

    /*
      Si usted esta leyendo este codigo, de antemano se le pide disculpas por la mezcla de ingles y español.
      Se tiene dominio de ambas lenguas, pero se utilizaba antes ingresar a la empresa nombres de variables
      en español y nos estamos adaptando al cambio. Muchas gracias por su comprension.
     */



}
