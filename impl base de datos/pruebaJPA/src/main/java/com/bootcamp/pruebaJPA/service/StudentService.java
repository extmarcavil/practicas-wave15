package com.bootcamp.pruebaJPA.service;

import com.bootcamp.pruebaJPA.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
}
