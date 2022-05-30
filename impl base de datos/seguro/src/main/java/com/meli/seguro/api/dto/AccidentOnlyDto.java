package com.meli.seguro.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class AccidentOnlyDto implements Serializable {
    private Long id;
    private LocalDate fechaSiniestro;
    private BigDecimal perdidaEconomica;
}
