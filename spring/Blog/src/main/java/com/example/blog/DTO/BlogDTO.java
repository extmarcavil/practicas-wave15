package com.example.blog.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class BlogDTO {

    private Integer id;
    private String title;
    private String authorName;
    private LocalDate date;

}
