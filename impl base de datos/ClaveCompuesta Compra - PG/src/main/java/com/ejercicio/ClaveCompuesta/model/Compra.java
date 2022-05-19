package com.ejercicio.ClaveCompuesta.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Data
@Entity
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Integer idCliente;

    @Id
    private LocalDate fecha;
}
