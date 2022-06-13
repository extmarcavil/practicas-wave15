package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "rol_id")
    UserRol rol;

    private String username;
    private String password;
}
