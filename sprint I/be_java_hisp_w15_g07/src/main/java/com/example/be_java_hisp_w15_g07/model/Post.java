package com.example.be_java_hisp_w15_g07.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

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

    private boolean hasPromo = false;
    private double discount;

    public Post(LocalDate date, Product detail, Integer category, Double price) {
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Post(LocalDate date, Product detail, Integer category, Double price, Double discount) {
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = true;
        this.discount= discount;
    }
}
