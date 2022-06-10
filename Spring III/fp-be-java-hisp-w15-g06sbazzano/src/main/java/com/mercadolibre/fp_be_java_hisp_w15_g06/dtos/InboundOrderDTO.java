package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterDeserializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InboundOrderDTO {

    private Long id;

    //@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = LocalDateAdapterSerializer.class)
    @JsonDeserialize(using = LocalDateAdapterDeserializer.class)
    private LocalDate order_date;

    private SectionDTO section;

    private List<BatchStockDTO> batch_stock;
}
