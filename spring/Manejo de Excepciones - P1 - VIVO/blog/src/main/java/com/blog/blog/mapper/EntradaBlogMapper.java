package com.blog.blog.mapper;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.entity.EntradaBlog;
import org.springframework.stereotype.Component;

@Component
public class EntradaBlogMapper {

    public EntradaBlogDTO entradaBlogaEntradaBlogDTO(EntradaBlog entradaBlog){
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO();
        entradaBlogDTO.setId(entradaBlog.getId());
        entradaBlogDTO.setAutor(entradaBlog.getNombreAutor());
        entradaBlogDTO.setTitulo(entradaBlog.getTitulo());
        entradaBlogDTO.setFecha(entradaBlog.getFechaPublicacion());

        return entradaBlogDTO;
    }

    public EntradaBlog entradaBlogDTOaEntradaBlog(EntradaBlogDTO entradaBlogDTO){
        EntradaBlog entradaBlog = new EntradaBlog();
        entradaBlog.setId(entradaBlogDTO.getId());
        entradaBlog.setNombreAutor(entradaBlogDTO.getAutor());
        entradaBlog.setTitulo(entradaBlogDTO.getTitulo());
        entradaBlog.setFechaPublicacion(entradaBlogDTO.getFecha());

        return entradaBlog;
    }
}
