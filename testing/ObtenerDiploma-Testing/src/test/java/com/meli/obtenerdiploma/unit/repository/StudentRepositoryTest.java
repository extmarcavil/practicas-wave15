package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {
    private static IStudentRepository studentRepository;

    @BeforeAll
    static void setup() {
        studentRepository = new StudentRepository();
    }

    @Test
    public void test_findAll() {
        // Arrange
        Set<StudentDTO> students;
        int expectedSize = 2;
        // Act
        students = studentRepository.findAll();
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertFalse(students.isEmpty()),
                () -> Assertions.assertEquals(expectedSize, students.size())
        );
    }
}
