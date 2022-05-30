package com.meli.seguro.api.dto;

import com.meli.seguro.api.dto.VehicleOnlyDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class AccidentDto implements Serializable {
    private Long id;
    private LocalDate fechaSiniestro;
    private BigDecimal perdidaEconomica;
    private VehicleOnlyDto vehicle;
}
