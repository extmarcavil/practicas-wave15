package com.example.student.service;

import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }
}
