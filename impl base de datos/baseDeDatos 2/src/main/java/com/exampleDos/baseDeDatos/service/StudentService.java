package com.exampleDos.baseDeDatos.service;

import com.exampleDos.baseDeDatos.repository.StudentRepository;

public class StudentService {

    private final StudentRepository stuRepo;

    public StudentService (StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
}
