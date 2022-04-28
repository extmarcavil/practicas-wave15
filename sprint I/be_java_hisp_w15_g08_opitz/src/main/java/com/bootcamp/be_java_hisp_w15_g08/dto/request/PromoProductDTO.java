package com.bootcamp.be_java_hisp_w15_g08.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoProductDTO extends NewPostDTO{

    private double discount;
    private boolean has_promo;

}
