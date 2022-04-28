package com.bootcamp.be_java_hisp_w15_g08.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewPostPromoDTO extends NewPostDTO{
    private boolean has_promo;
    private double discount;

}
