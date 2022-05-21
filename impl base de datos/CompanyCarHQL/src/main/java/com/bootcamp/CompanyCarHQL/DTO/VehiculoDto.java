package com.bootcamp.CompanyCarHQL.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehiculoDto {

    private String patente;
    private String marca;
    private Integer year_of_production;
    private Integer amount_of_wheels;

    public VehiculoDto(String patente, String marca, Integer year_of_production, Integer amount_of_wheels) {
        this.patente = patente;
        this.marca = marca;
        this.year_of_production = year_of_production;
        this.amount_of_wheels = amount_of_wheels;
    }

    public VehiculoDto() {
    }
}
