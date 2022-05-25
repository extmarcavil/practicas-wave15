package com.example.hql_seguros_auto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiclePlateBrandModelDTO {
    private String plate;

    private String brand;

    private String model;
}
