package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostDTO {
    private int post_id;
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

    public PostDTO() {
    }

    public PostDTO(int post_id, LocalDate date, ProductDTO detail, int category, double price, boolean has_promo, double discount) {
        this.post_id = post_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
