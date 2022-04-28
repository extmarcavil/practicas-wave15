package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoProductNotUserIdDTO extends PostNotUserIdDTO {

    private double discount;
    private boolean has_promo;

}
