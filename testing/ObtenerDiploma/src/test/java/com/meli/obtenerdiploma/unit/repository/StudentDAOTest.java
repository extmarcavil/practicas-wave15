package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    IStudentDAO repo;

    @BeforeEach
    void setup () { repo = new StudentDAO();}

    @Test
    @DisplayName("Busca por ID 1 y encuentra a Juan")
    void findByIdIsCorrect () {
        StudentDTO user = repo.findById(1L);
        Assertions.assertEquals("Juan", user.getStudentName());
    }

    @Test
    @DisplayName("Busca por ID inexistente y devuelve una Exception")
    void finByIdThrowsException () {
        Assertions.assertThrows(StudentNotFoundException.class, () -> repo.findById(10L));
    }

    @Test
    @DisplayName("El estudiante buscado existe")
    void existsFindsStudent () {
        StudentDTO user = repo.findById(1L);
        Assertions.assertTrue(repo.exists(user));
    }

    @Test
    @DisplayName("El estudiante buscado no existe")
    void existsDoesNotFindStudent () {
        StudentDTO user = new StudentDTO();
        Assertions.assertFalse(repo.exists(user));
    }

    @Test
    @DisplayName("Guarda correctamente un estudiante")
    void saveAStudent () {
        StudentDTO newStudent = new StudentDTO();
        repo.save(newStudent);
        Assertions.assertTrue(repo.exists(newStudent));
    }

    @Test
    @DisplayName("Elimina correctamente un estudiante")
    void deleteAStudent () {
        //StudentDTO newStudent = new StudentDTO();
        //repo.save(newStudent);
        Assertions.assertTrue(repo.delete(1L));

    }
}
