package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

    private IStudentRepository studentRepository;


    @BeforeEach
    void setUp() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Find all students")
    void findAll() {

        // Arrange

        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        Assertions.assertNotNull(students);
    }
}
