package com.bootcamp.Blog.service;

import com.bootcamp.Blog.dto.EntradaBlogDTO;
import com.bootcamp.Blog.exceptions.EntradaBlogNotFoundException;
import com.bootcamp.Blog.model.EntradaBlog;
import com.bootcamp.Blog.repository.IEntradaBlogRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    private final IEntradaBlogRepo repo;
    private final ModelMapper mapper;

    public EntradaBlogService(IEntradaBlogRepo repo){
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<EntradaBlogDTO> getAllBlogEntriesDTO() {
        return repo.getAllBlogEntries().stream()
                .map(eb -> mapper.map(eb,EntradaBlogDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EntradaBlogDTO getBlogEntriesByNameDTO(Integer id) {

        EntradaBlog entradaBlog = repo.getAllBlogEntries().stream()
                .filter(eb -> eb.getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new EntradaBlogNotFoundException("No se encontró ningún registro con el id " + id + " pruebe con otro."));

        /*
        for(EntradaBlog eblog : repo.getAllBlogEntries()){
            if(eblog.getId().equals(id)) {
                EntradaBlog eb = repo.getBlogEntryById(id);
                return mapper.map(eb,EntradaBlogDTO.class);
            }
            else
                throw new EntradaBlogNotFoundException("No se encontró ningún registro con el id " + id + " pruebe con otro.");
        }

        */

        return mapper.map(entradaBlog,EntradaBlogDTO.class);
    }

    public String postBlogEntry( EntradaBlogDTO eb){

        for(EntradaBlog entradaBlog : repo.getAllBlogEntries()){
            if(entradaBlog.getId().equals(eb.getId()))
                throw new RuntimeException("Ya se encuentra una entrada de blog con el id " + eb.getId() + ".");
            else
                break;
        }

        EntradaBlog entrada_blog = mapper.map(eb, EntradaBlog.class);
        repo.addBlogEntry(entrada_blog);
        return "La entrada al blog con id: " + entrada_blog.getId() + " se agregó exitosamente.";
    }
}
