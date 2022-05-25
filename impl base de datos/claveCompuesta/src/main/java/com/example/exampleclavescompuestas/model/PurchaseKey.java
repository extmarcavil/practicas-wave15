package com.example.exampleclavescompuestas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseKey implements Serializable {
    @Id
    private Integer clientId;
    @Id
    private LocalDate date;
}
