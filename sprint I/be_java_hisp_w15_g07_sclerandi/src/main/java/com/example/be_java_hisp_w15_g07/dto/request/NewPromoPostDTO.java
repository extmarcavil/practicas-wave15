package com.example.be_java_hisp_w15_g07.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPromoPostDTO extends NewPostDTO {
    private boolean hasPromo;
    private double discount;
}