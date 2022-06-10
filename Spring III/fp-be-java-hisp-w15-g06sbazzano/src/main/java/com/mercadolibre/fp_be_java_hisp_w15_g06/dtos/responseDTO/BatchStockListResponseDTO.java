package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.BatchStockDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BatchStockListResponseDTO {
    private List<BatchStockDTO> batchStockDTOList;
}
