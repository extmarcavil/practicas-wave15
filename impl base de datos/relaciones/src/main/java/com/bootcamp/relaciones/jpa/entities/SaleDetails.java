package com.bootcamp.relaciones.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "sale_details")
public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}
