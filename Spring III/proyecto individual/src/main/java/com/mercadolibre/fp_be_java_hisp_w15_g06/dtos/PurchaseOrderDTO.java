package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterDeserializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterSerializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PurchaseOrderDTO {

    @JsonSerialize(using = LocalDateAdapterSerializer.class)
    @JsonDeserialize(using = LocalDateAdapterDeserializer.class)
    private LocalDate date;

    @JsonProperty("buyer_id")
    private Long buyerId;

    @JsonProperty("order_status")
    private OrderStatus orderStatus;

    private List<RequestProductDTO> products;

}
