package com.example.hqlejerciciopractico.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double economicLost;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name ="vehiculo_id", nullable = false)
    private Vehiculo vehiculo;
}
