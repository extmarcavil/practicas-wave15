package com.bootcamp.blog.dto;

import lombok.*;

@Data
public class EntradaBlogDTO {
    private Integer id;
    private String title;
    private String authorName;
    private String datePublished;
}
