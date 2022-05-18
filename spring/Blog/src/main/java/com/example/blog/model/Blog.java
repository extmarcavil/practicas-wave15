package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Blog {

    private Integer id;
    private String title;
    private String authorName;
    private LocalDate date;

}
