package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.InboundOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderRequestDTO {

    private InboundOrderDTO inbound_order;
}
