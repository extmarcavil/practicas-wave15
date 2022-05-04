package com.example.be_java_hisp_w15_g07_ravelli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
    private Boolean hasPromo;
    private Double discount;

    public Post(LocalDate date, Product detail, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    /**
     * verify promo setted
     * verifica que hasPromo venga seteado por si a caso no venga seteado en el request..
     * por ejemplo, en la historia de usuario 5
     */
    public Boolean verifyPromoSetted(){
        return this.hasPromo != null;
    }
}
