package com.example.comprasclavecompuesta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@NoArgsConstructor
@Setter @Getter
@Entity
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Integer clienteId;
    @Id
    private LocalDate fecha;
}
