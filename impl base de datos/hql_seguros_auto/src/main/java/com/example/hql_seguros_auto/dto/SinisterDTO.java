package com.example.hql_seguros_auto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinisterDTO {
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    private Double economicLoss;

    private VehicleDTO vehicle;
}
