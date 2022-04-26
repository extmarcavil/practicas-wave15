package com.example.be_java_hisp_w15_g07.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private Integer postId;
    private Integer user;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;

}
