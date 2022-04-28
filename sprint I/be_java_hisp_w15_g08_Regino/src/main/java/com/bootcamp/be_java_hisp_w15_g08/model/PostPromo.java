package com.bootcamp.be_java_hisp_w15_g08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromo extends Post{

    private boolean has_promo;
    private double discount;

    public void aplicarDescuento (){
        if(has_promo){
            setPrice(getPrice()*(1-discount));
        }
    }
}
