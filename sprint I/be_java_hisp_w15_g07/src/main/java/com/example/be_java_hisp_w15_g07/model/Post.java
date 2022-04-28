package com.example.be_java_hisp_w15_g07.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor

public class Post {
    private Integer postId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Float discount;

    public Post(LocalDate date, Product detail, Integer category, Double price, Boolean hasPromo, Float discount) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Post(LocalDate date, Product detail, Integer category, Double price) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
    }
}
