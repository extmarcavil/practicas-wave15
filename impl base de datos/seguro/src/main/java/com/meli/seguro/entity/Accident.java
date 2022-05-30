package com.meli.seguro.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accident")
@Getter @Setter
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha_siniestro")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaSiniestro;

    @Column(name = "perdida_economica", precision = 8, scale = 2)
    private BigDecimal perdidaEconomica;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    //@JsonBackReference
    private Vehicle vehicle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Accident accident = (Accident) o;
        return id != null && Objects.equals(id, accident.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}