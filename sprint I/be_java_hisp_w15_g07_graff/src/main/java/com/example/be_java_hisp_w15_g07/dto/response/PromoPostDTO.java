package com.example.be_java_hisp_w15_g07.dto.response;

import com.example.be_java_hisp_w15_g07.dto.request.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PromoPostDTO extends PostDTO{

    private Boolean hasPromo=false;
    private Double discount;

    public PromoPostDTO(Integer postId, LocalDate date, ProductDTO detail, Integer category, Double price, Double discount) {
        super(postId, date, detail, category, price);
        this.discount = discount;
        this.hasPromo = true;
    }
}
