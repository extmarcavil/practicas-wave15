package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PromoRespDTO {

    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Integer category;
    private Double price;
    private ProductDTO detail;
    private Boolean has_promo;
    private double discount;

    public PromoRespDTO(Integer postId, LocalDate date, Integer category, Double price, ProductDTO detail, Boolean has_promo, double discount) {
        this.postId = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
        this.has_promo = has_promo;
        this.discount = discount;
    }


}
