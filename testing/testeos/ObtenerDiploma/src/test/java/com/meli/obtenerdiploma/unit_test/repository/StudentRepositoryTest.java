package com.meli.obtenerdiploma.unit_test.repository;

import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentRepositoryTest {

    private IStudentRepository studentRepository;
    @BeforeEach
    void setup(){
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName(" verificamos si se obtienen todos los estudiantes correctamente")
    void findAllCorrect(){
       studentRepository.findAll();
       Assertions.assertAll(
               ()-> Assertions.assertTrue(studentRepository.findAll().size()!=0),
               ()-> Assertions.assertFalse(studentRepository.findAll().isEmpty())
       );
    }
}
