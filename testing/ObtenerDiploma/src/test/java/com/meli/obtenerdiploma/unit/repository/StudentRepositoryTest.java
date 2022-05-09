package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }


    /**
     * Obtener todos los estudiantes almacenados;
     */
    @Test
    void getAllStudentsTest() {

        //Arrange

        //Act
        Set<StudentDTO> studentsList = studentRepository.findAll();

        //Assert
        assertAll(
                () -> assertEquals(4, studentsList.size(), "La cantidad de Registros de la BD no es valido"),
                () -> assertTrue(5 > studentsList.size(), "Los registros de estudiantes no son menores a 5")
        );
    }
}