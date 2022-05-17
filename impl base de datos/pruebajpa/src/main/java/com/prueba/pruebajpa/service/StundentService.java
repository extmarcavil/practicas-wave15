package com.prueba.pruebajpa.service;

import com.prueba.pruebajpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StundentService {
    private final StudentRepository studentRepository;
    public StundentService( StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
}
