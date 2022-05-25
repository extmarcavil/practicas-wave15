package com.example.exampleclavescompuestas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(value = PurchaseKey.class)
public class Purchase {
    @Id
    private Integer clientId;
    @Id
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
