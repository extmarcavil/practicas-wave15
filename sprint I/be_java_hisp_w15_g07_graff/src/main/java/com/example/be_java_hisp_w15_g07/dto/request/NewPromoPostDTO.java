package com.example.be_java_hisp_w15_g07.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class NewPromoPostDTO extends NewPostDTO{

    private Boolean hasPromo=false;
    private Double discount;

    public NewPromoPostDTO(Integer postId, LocalDate date, ProductDTO detail, Integer category, Double price, Double discount) {
        super(postId, date, detail, category, price);
        this.discount = discount;
        this.hasPromo = true;
    }
}
