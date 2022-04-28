package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPost {


    private int post_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private String category;
    private Double price;
    private boolean has_promo; // Como manejar ?? donde puedo validar esto?
    private double discount;

    public String getProductName(){
        return detail.getProduct_name();
    }

}
