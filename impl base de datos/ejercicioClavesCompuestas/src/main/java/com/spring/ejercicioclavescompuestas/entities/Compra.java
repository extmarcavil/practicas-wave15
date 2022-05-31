package com.spring.ejercicioclavescompuestas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long id;

    @Id
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    private String description;
}
