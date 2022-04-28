package com.bootcamp.be_java_hisp_w15_g08.model;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromoProduct extends Post{
    private Double discount;
    private Boolean has_promo;
}
