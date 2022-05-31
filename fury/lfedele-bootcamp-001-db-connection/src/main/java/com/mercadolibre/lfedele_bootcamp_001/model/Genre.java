package com.mercadolibre.lfedele_bootcamp_001.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ranking", nullable = false)
    private Integer ranking;

    @Column(name = "active", nullable = false)
    private Integer active;
}
