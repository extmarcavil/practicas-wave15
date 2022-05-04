package com.bootcamp.be_java_hisp_w15_g02.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PostCreateDTO {
    private int user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private String category;
    private double price;
    private boolean has_Promo;
    private double discount;

    public PostCreateDTO() {
    }

    public PostCreateDTO(int user_id, LocalDate date, ProductDTO detail, String category, double price) {
        this.user_id = user_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public PostCreateDTO(int user_id, LocalDate date, ProductDTO detail, String category, double price, boolean has_Promo, double discount) {
        this.user_id = user_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.has_Promo = has_Promo;
        this.discount = discount;
    }
}
