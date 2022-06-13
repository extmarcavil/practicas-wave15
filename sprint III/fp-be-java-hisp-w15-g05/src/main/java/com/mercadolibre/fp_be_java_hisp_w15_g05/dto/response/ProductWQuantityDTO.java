package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWQuantityDTO {
    private String product_name;
    private Integer product_quantity;
}
