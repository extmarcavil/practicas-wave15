package com.spring.ejercicioclavescompuestas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
public class CompraKey implements Serializable {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;

}
