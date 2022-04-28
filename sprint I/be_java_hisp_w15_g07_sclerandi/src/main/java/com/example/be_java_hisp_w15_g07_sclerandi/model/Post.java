package com.example.be_java_hisp_w15_g07_sclerandi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    private Integer postId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;

    public Post(LocalDate date, Product detail, Integer category, Double price) {
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
