package com.bootcamp.be_java_hisp_w15_g08.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PostPromo extends Post{

    private boolean has_promo;
    private double discount;
}
