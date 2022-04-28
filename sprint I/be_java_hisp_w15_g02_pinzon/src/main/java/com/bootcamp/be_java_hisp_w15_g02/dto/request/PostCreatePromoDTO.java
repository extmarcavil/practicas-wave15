package com.bootcamp.be_java_hisp_w15_g02.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostCreatePromoDTO {
    private int user_id;
    private Date date;
    private ProductDTO detail;
    private String category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public PostCreatePromoDTO() {
    }

    public PostCreatePromoDTO(int user_id, Date date, ProductDTO detail, String category, double price, boolean hasPromo, double discount) {
        this.user_id = user_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}

