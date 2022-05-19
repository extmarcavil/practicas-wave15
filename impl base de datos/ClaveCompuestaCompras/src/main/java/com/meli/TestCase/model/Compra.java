package com.meli.TestCase.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Compra {

    @Id
    LocalDate fecha;

    @Id
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    Cliente cliente;

    private String description;
}
