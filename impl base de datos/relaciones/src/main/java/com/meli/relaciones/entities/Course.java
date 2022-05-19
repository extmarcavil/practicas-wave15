package com.meli.relaciones.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
    private String name;

    public Course() {
    }

    public void addStudents(Student student){
        if(students == null){
            students = new HashSet<>();
        }
        students.add(student);
    }
}
