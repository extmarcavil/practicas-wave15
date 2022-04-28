package com.bootcamp.be_java_hisp_w15_g02.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostCreateDTO {
    private int user_id;
    private Date date;
    private ProductDTO detail;
    private String category;
    private double price;
    private boolean has_Promo;
    private double discount;

    public PostCreateDTO() {
    }

    public PostCreateDTO(int user_id, Date date, ProductDTO detail, String category, double price) {
        this.user_id = user_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public PostCreateDTO(int user_id, Date date, ProductDTO detail, String category, double price, boolean has_Promo, double discount) {
        this.user_id = user_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.has_Promo = has_Promo;
        this.discount = discount;
    }
}
