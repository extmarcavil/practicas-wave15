package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InboundOrderResponseDTO {
    private List<BatchStockDTO> batch_stock;

}
