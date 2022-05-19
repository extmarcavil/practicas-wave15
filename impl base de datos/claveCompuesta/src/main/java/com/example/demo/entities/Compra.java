package com.example.demo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    private Long id;
    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
    private String descripcion;
}
