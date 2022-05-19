package com.example.demo.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CompraKey implements Serializable {

    private Long clienteId;
    private LocalDate fecha;
}

