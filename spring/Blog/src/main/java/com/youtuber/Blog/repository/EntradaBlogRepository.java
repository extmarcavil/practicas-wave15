package com.youtuber.Blog.repository;

import com.youtuber.Blog.dto.request.EntradaBlogRequestDTO;
import com.youtuber.Blog.dto.response.EntradaBlogResponseDTO;
import com.youtuber.Blog.model.EntradaBlog;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{
    List<EntradaBlogResponseDTO> listadoBlogs;
    ModelMapper mm = new ModelMapper();
    public EntradaBlogRepository (){
        listadoBlogs= new ArrayList<>();
    }

    @Override
    public Integer guardarBlog(EntradaBlogRequestDTO dto) {
        listadoBlogs.add(mm.map(dto,EntradaBlogResponseDTO.class));
        return dto.getId();
    }

    @Override
    public EntradaBlogResponseDTO buscarPorId(Integer id) {
        return listadoBlogs.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseGet(EntradaBlogResponseDTO::new);
    }

    @Override
    public List<EntradaBlogResponseDTO> getTodosBlogs() {
        return listadoBlogs;
    }

    @Override
    public boolean isNull(EntradaBlogResponseDTO dto) {
        return dto.getId()==null;
    }

    @Override
    public Boolean existeBlog(Integer id) {
        return listadoBlogs.stream().anyMatch(b -> b.getId().equals(id));
    }

}
