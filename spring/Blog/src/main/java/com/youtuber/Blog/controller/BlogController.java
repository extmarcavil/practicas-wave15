package com.youtuber.Blog.controller;

import com.youtuber.Blog.dto.request.EntradaBlogRequestDTO;
import com.youtuber.Blog.dto.response.EntradaBlogResponseDTO;
import com.youtuber.Blog.repository.IEntradaBlogRepository;
import com.youtuber.Blog.service.IBlogService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BlogController {

    private IBlogService blogService;

    public BlogController (IBlogService blogService){
        this.blogService=blogService;
    }

    @PostMapping(value="/blog")
    public Integer guardarBlog (@RequestBody EntradaBlogRequestDTO dto) {
        return blogService.guardarBlog(dto);
    }
    @GetMapping("/blog/{id}")
    public EntradaBlogResponseDTO buscarPorId(@PathVariable Integer id){
        return blogService.buscarPorId(id);
    }
    @GetMapping("/blogs")
    public List<EntradaBlogResponseDTO> getTodosBlogs(){
        return blogService.getTodosBlogs();
    }
    
}
