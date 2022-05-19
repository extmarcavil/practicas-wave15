package com.bootcamp.hql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Migrations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "migration")
    private String migration;
    @Basic
    @Column(name = "batch")
    private Integer batch;

}
