package com.example.hql_seguros_auto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSinisterDTO {
    private List<VehiclePlateBrandModelDTO> vehicle;

    private Double totalCost;
}
