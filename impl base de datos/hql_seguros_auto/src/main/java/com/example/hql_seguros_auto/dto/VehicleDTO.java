package com.example.hql_seguros_auto.dto;

import com.example.hql_seguros_auto.entity.Sinister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id;

    private String plate;

    private String brand;

    private String model;

    private Integer fabricationYear;

    private Integer wheels;
}
