package com.bootcamp.be_java_hisp_w15_g02.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class DiscountedPostCreateDTO {

    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public DiscountedPostCreateDTO() {
    }

    public DiscountedPostCreateDTO(int userId, LocalDate date, ProductDTO detail, int category, double price,
                                   boolean hasPromo, double discount) {
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
