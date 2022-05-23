package com.bootcamp.consecionariahql.Model.DTO.Vehicle;

import com.bootcamp.consecionariahql.Model.Crash;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO implements Serializable {

    private String patent;
    private String brand;
    private String model;
    private int fabricationYear;
    private int amountOfTires;
    private Set<Crash> crashes;
}
