package com.mercadolibre.fp_be_java_hisp_w15_g06.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "warehouses")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Agent agent;
}
