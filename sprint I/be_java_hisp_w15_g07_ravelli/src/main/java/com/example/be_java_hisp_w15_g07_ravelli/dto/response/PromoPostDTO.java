package com.example.be_java_hisp_w15_g07_ravelli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostDTO{
    private Boolean hasPromo;
    private Double discount;
}
