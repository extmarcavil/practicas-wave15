package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

    IStudentRepository repo;

    @BeforeEach
    void setup () {
        repo = new StudentRepository();
    }

    @Test
    @DisplayName("Encontrar lista con alumnos")
    void findAllTest () {
        Set<StudentDTO> allStudents = repo.findAll();
        Assertions.assertTrue(allStudents.size() > 1);
    }

}
