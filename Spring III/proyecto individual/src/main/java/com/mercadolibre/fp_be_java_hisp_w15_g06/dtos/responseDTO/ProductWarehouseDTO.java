package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWarehouseDTO {

    private Long product_id;
    private List<WarehouseQuatityResponseDTO> warehouses;
}
