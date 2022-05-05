package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

    IStudentRepository studentRepository;

    @BeforeEach
    void setup(){studentRepository = new StudentRepository();}

    @Test
    public void findAll(){
        Set<StudentDTO> studentList = studentRepository.findAll();
        Assertions.assertNotNull(studentList);
    }
}
