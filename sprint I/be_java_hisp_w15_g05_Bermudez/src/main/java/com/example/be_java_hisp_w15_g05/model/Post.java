package com.example.be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int userId;
    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(int userId, int postId, LocalDate date, Product detail, int category, double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0;
    }
}
