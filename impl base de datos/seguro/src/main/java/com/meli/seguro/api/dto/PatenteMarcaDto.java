package com.meli.seguro.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class PatenteMarcaDto {
    private final String patente;
    private final String marca;
}
