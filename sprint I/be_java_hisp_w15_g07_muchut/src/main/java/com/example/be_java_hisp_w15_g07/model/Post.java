package com.example.be_java_hisp_w15_g07.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;


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
    private boolean hasPromo;
    private double discount;

    public Post(LocalDate date, Product detail, Integer category, Double price) {
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Post(Integer postId, LocalDate date, Product detail, Integer category, Double price, boolean hasPromo, double discount) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
