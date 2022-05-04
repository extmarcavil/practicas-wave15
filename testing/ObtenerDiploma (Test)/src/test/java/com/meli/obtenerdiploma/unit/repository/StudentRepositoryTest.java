package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.utils.SchoolFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {

    IStudentRepository repository;

    @BeforeEach
    void setup() {
        repository = new StudentRepository();
    }

    @Test
    @DisplayName("Find all students")
    void findAllAlumnsSuccess() {
        // Arrange
        Set<StudentDTO> expected = SchoolFactory.getAllStudents();

        // Act
        Set<StudentDTO> result = repository.findAll();

        // Asssert
        assertEquals(expected, result, "The lists are different");
    }
}
