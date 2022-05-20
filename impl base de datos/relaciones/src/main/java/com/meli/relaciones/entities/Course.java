package com.meli.relaciones.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
public class Course {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //comentado porque rompia al agregar nuevos cursos
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> std;

    public void addStudent(Student s) {
        std.add(s);
    }

    public Course(Long id) {
        this.id = id;
        std = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Set<Long> getStd() {
        return std.stream().map(Student::getId).collect(Collectors.toSet());
    }
}
