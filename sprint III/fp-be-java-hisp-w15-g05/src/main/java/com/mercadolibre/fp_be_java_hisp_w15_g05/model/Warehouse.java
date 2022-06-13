package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer warehouse_id;

    private String name;
}
