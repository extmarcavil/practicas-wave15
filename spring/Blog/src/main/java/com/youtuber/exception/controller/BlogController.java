package com.youtuber.exception.controller;

import com.youtuber.exception.dto.BlogDTO;
import com.youtuber.exception.dto.BlogIdDTO;
import com.youtuber.exception.dto.ResponseExceptionDTO;
import com.youtuber.exception.entity.EntradaBlogEntity;
import com.youtuber.exception.exception.IdExistException;
import com.youtuber.exception.exception.IdNotFoundException;
import com.youtuber.exception.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogIdDTO> saveBlogEntry(@RequestBody EntradaBlogEntity entry) throws IdExistException {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.saveBlogEntry(entry));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable Integer id) throws IdNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getBlog(id));
    }

    @GetMapping
    public ResponseEntity<Map<Integer, BlogDTO>> getBlogs() throws IdNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getBlogs());
    }


    @ExceptionHandler(IdExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ResponseExceptionDTO> idExistHandler(Exception e) {
        ResponseExceptionDTO response = new ResponseExceptionDTO(e.getMessage(), HttpStatus.CONFLICT);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseExceptionDTO> idNotFoundHandler(Exception e) {
        ResponseExceptionDTO response = new ResponseExceptionDTO(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

}
