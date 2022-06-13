package com.mercadolibre.fp_be_java_hisp_w15_g05.utils;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.InboundOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.SectionDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.InboundOrderRequestDTO;

import java.time.LocalDate;

public class InboundOrderFactory {

    public static InboundOrderRequestDTO getInboundOrderRequest() {
        InboundOrderRequestDTO request = new InboundOrderRequestDTO();
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        inboundOrderDTO.setOrder_date(LocalDate.of(2022, 02, 02));
        inboundOrderDTO.setOrder_number(1);
        SectionDTO sectionDTO = new SectionDTO(1, 1);
        inboundOrderDTO.setSection(sectionDTO);
        inboundOrderDTO.setBatch_stock(BatchFactory.getbatchDTOList());
        inboundOrderDTO.setOrder_date(LocalDate.of(2022, 12, 30));

        request.setInbound_order(inboundOrderDTO);
        return request;
    }
}
