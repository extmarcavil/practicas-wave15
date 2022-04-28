package com.example.be_java_hisp_w15_g07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPost extends Post{
    private boolean has_promo;
    private Float discount;
}
