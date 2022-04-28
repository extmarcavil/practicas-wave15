package com.bootcamp.be_java_hisp_w15_g02.dto.request;

import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PromoPostDTO {
    private int userId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private int category;
    private Product detail;
    private double price;
    private boolean hasPromo;
    private double discount;

    public PromoPostDTO(int userId, LocalDate date, int category, Product detail, double price, boolean hasPromo, double discount) {
        this.userId = userId;
        this.date = date;
        this.category = category;
        this.detail = detail;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
