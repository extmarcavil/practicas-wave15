package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SuccessfulOrderDTO {

    @JsonProperty("total_price")
    private Double totalPrice;
}
