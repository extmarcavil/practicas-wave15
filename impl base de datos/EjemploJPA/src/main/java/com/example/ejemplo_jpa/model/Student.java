package com.example.ejemplo_jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;

}
