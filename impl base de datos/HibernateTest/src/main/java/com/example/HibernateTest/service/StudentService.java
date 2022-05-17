package com.example.HibernateTest.service;

import com.example.HibernateTest.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository stuRepo;


    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
}
