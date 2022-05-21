package com.example.claveCompuesta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Long clienteId;

    @Id
    private LocalDate fecha;

}
