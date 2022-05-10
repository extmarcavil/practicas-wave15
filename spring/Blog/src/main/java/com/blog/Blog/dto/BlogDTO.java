package com.blog.Blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BlogDTO {

    private int idBlog;
    private String título;
    private String nombreDelAutor;
    LocalDate fechaDePublicación;


}
