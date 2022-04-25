package com.youtuber.Blog.service;

import com.youtuber.Blog.dto.request.EntradaBlogRequestDTO;
import com.youtuber.Blog.dto.response.EntradaBlogResponseDTO;
import com.youtuber.Blog.exceptions.BadRequestException;
import com.youtuber.Blog.exceptions.NotFoundException;
import com.youtuber.Blog.repository.IEntradaBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{
    IEntradaBlogRepository entradaBlogRepository;

    public BlogServiceImpl(IEntradaBlogRepository entradaBlogRepository){
        this.entradaBlogRepository=entradaBlogRepository;
    }
    @Override
    public Integer guardarBlog(EntradaBlogRequestDTO dto) {
        if(entradaBlogRepository.existeBlog(dto.getId())){
            throw new BadRequestException("El id ingresado ya se encuentra registado!");
        }
        return entradaBlogRepository.guardarBlog(dto);
    }

    @Override
    public EntradaBlogResponseDTO buscarPorId(Integer id) {
        EntradaBlogResponseDTO entradaBlogResponseDTO= entradaBlogRepository.buscarPorId(id);
        if(entradaBlogRepository.isNull(entradaBlogResponseDTO)){
            throw new NotFoundException("Blog no encontrado!");
        }
        return entradaBlogResponseDTO;
    }

    @Override
    public List<EntradaBlogResponseDTO> getTodosBlogs() {
        return entradaBlogRepository.getTodosBlogs();
    }

    @Override
    public Boolean existeBlog(Integer id) {
        return entradaBlogRepository.existeBlog(id);
    }
}
