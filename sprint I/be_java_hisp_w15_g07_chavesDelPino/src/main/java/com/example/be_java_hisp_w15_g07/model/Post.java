package com.example.be_java_hisp_w15_g07.model;

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

public class Post {
    private Integer postId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;
    //US-0010
    private Boolean hasPromo;
    private Double discount;

    public Post(LocalDate date, Product detail, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        //US-0010
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
