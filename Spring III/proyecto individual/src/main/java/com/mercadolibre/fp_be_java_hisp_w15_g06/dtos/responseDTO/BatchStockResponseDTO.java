package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.*;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class BatchStockResponseDTO {

    private Long id;

    private Long product_id;

    private Double current_temperature;

    private Double minimum_temperature;

    private Integer initial_quantity;

    private Integer current_quantity;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime manufacturing_time;

    @JsonSerialize(using = LocalDateAdapterSerializer.class)
    @JsonDeserialize(using = LocalDateAdapterDeserializer.class)
    private LocalDate due_date;


    public BatchStockResponseDTO(Batch batch){
        this.id = batch.getId();
        this.product_id = batch.getProduct().getId();
        this.current_temperature = batch.getCurrentTemperature();
        this.minimum_temperature = batch.getMinimumTemperature();
        this.initial_quantity = batch.getInitialQuantity();
        this.current_quantity = batch.getCurrentQuantity();
        this.manufacturing_time = batch.getManufacturingTime();
        this.due_date = batch.getDueDate();
    }

    public BatchStockResponseDTO(Long id, Long product_id, Double current_temperature, Double minimum_temperature, Integer initial_quantity, Integer current_quantity, LocalDateTime manufacturing_time, LocalDate due_date) {
        this.id = id;
        this.product_id = product_id;
        this.current_temperature = current_temperature;
        this.minimum_temperature = minimum_temperature;
        this.initial_quantity = initial_quantity;
        this.current_quantity = current_quantity;
        this.manufacturing_time = manufacturing_time;
        this.due_date = due_date;
    }

    public BatchStockResponseDTO(Long id, Integer current_quantity, LocalDate due_date) {
        this.id = id;
        this.current_quantity = current_quantity;
        this.due_date = due_date;
    }

    public static BatchStockResponseDTO from(Batch batch) {
        return new BatchStockResponseDTO(batch.getId(), batch.getCurrentQuantity(), batch.getDueDate());
    }


}