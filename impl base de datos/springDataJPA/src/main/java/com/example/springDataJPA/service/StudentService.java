package com.example.springDataJPA.service;

import com.example.springDataJPA.repository.StudentRepository;

public class StudentService {

    private final StudentRepository stuRepo;


    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }


}
