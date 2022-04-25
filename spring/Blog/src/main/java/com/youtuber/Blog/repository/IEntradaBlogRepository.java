package com.youtuber.Blog.repository;

import com.youtuber.Blog.dto.request.EntradaBlogRequestDTO;
import com.youtuber.Blog.dto.response.EntradaBlogResponseDTO;

import java.util.List;

public interface IEntradaBlogRepository {
    Integer guardarBlog(EntradaBlogRequestDTO dto);
    EntradaBlogResponseDTO buscarPorId(Integer id);
    List<EntradaBlogResponseDTO> getTodosBlogs();
    boolean isNull(EntradaBlogResponseDTO dto);
    Boolean existeBlog(Integer id);
}
