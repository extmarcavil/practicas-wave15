package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {
    IStudentRepository studentRepository;

    @BeforeEach
    void setup() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Testeamos el FindAll()")
    void findAllTest() {
        //arrange
        Set<StudentDTO> setStudents;
        //act
        setStudents = studentRepository.findAll();
        //assert
        Assertions.assertNotNull(setStudents);
    }

}
