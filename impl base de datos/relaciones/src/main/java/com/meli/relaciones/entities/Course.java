package com.meli.relaciones.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "courses",
            fetch= FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Student> std;

    public Course(Long id, String name, Set<Student> std) {
        this.id = id;
        this.name = name;
        this.std = std;
    }

    public Course() {
    }
}
