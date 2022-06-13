package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderResponseDTO {

    private List<BatchDTO> batch_stock;
}
