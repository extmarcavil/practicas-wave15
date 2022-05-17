package com.example.proyectoBDD.service;

import com.example.proyectoBDD.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository stuRepo;


    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
}
