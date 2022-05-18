package com.example.clavecompuesta.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "compra")
@IdClass(CompraKey.class)
@Getter @Setter
public class Compra {
    @Id
    @ManyToOne
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private Cliente clienteId;

    @Id
    private LocalDate fecha;

}