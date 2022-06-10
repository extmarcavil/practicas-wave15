package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterDeserializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.adapter.LocalDateAdapterSerializer;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter @Setter
public class BatchSectionResponseDTO {

    private Long bach_id;

    private Double current_temperature;

    private Double minimum_temperature;

    private Integer initial_quantity;

    private Integer current_quantity;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime manufacturing_time;

    @JsonSerialize(using = LocalDateAdapterSerializer.class)
    @JsonDeserialize(using = LocalDateAdapterDeserializer.class)
    private LocalDate due_date;

    public BatchSectionResponseDTO(Long bach_id, Double current_temperature, Double minimum_temperature, Integer initial_quantity, Integer current_quantity, LocalDateTime manufacturing_time, LocalDate due_date) {
        this.bach_id = bach_id;
        this.current_temperature = current_temperature;
        this.minimum_temperature = minimum_temperature;
        this.initial_quantity = initial_quantity;
        this.current_quantity = current_quantity;
        this.manufacturing_time = manufacturing_time;
        this.due_date = due_date;
    }


    public static BatchSectionResponseDTO from(Batch batch) {
        return new BatchSectionResponseDTO(batch.getId(),batch.getCurrentTemperature(),
                batch.getMinimumTemperature(),batch.getInitialQuantity(),batch.getCurrentQuantity(),
                batch.getManufacturingTime(),batch.getDueDate());
    }


}