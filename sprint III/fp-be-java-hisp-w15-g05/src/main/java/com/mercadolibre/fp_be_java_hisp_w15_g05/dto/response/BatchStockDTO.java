package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BatchStockDTO {
    private SectionWarehouseDTO section;
    private Integer product_id;
    private List<BatchProductDTO> batch_stock;
}
