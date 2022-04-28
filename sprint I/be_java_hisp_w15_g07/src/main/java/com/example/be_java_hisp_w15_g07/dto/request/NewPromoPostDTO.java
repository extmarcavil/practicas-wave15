package com.example.be_java_hisp_w15_g07.dto.request;

import com.example.be_java_hisp_w15_g07.dto.response.PostDTO;

import lombok.Data;

@Data
public class NewPromoPostDTO extends NewPostDTO {

    private Boolean has_promo;
    private Float discount;
}
