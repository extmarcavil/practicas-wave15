package com.youtuber.Blog.service;

import com.youtuber.Blog.dto.request.EntradaBlogRequestDTO;
import com.youtuber.Blog.dto.response.EntradaBlogResponseDTO;

import java.util.List;

public interface IBlogService {
    Integer guardarBlog(EntradaBlogRequestDTO dto);
    EntradaBlogResponseDTO buscarPorId(Integer id);
    List<EntradaBlogResponseDTO> getTodosBlogs();
    Boolean existeBlog(Integer id);
}
