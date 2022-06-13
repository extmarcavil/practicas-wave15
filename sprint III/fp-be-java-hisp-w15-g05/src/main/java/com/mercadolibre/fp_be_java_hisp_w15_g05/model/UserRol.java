package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolE rol;
}
