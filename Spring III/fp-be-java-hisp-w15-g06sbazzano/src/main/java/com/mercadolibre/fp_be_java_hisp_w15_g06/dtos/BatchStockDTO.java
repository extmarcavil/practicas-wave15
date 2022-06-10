package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateTimeAdapterDeserializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateTimeAdapterSerializer;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterDeserializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterSerializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Date;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BatchStockDTO {

    private Long id;

    private Long productId;

    private Double currentTemperature;

    private Double minimumTemperature;

    private Integer initialQuantity;

    private Integer currentQuantity;

    @JsonDeserialize(using = LocalDateTimeAdapterDeserializer.class)
    @JsonSerialize(using = LocalDateTimeAdapterSerializer.class)
    private LocalDateTime manufacturingTime;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dueDate;

    private Long inboundId;

    //@JsonSerialize(using = LocalDateAdapterSerializer.class)
    //@J sonDeserialize(using = LocalDateAdapterDeserializer.class)
    //@JsonProperty("due_date")
    //private LocalDate dueDate;

    public BatchStockDTO(Batch batch){
        this.id = batch.getId();
        this.productId = batch.getProduct().getId();
        this.currentTemperature = batch.getCurrentTemperature();
        this.minimumTemperature = batch.getMinimumTemperature();
        this.initialQuantity = batch.getInitialQuantity();
        this.currentQuantity = batch.getCurrentQuantity();
        this.manufacturingTime = batch.getManufacturingTime();
        this.dueDate = batch.getDueDate();
    }
}
