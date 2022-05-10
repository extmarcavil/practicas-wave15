package com.blog.Blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private int idBlog;
    private String titulo;
    private String nombreDelAutor;
    LocalDate fechaDePublicacion;
}
