package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePurchaseOrderDTO {
    private double total_price;
}
