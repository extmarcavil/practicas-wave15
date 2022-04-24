package com.bootcamp.blog.model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EntradaBlog {
    private Integer id;
    private String title;
    private String authorName;
    private String datePublished;


}
