package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.StudentFactory;
import com.meli.obtenerdiploma.util.SubjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestStudentDAO {

    private IStudentDAO studentDAO;

    @BeforeEach
    private void initialize() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Agregar un estudiante")
    public void test_addAStudent() {
        // Arrange
        SubjectDTO s1 = SubjectFactory.createSubject("Programacion Funcional",10D);
        SubjectDTO s2 = SubjectFactory.createSubject("Objetos III",10D);

        StudentDTO s = StudentFactory.createStudent(
                "Max Power", 10D, "some message", Arrays.asList(s1, s2));

        // Act
        this.studentDAO.save(s);

        // Assert
        Assertions.assertTrue(this.studentDAO.exists(s));
    }

    @Test
    @DisplayName("Buscar alumno por id")
    public void test_findStudentById() {
        // Arrange
        Long id = 1L;
        // Act
        StudentDTO result = studentDAO.findById(id);
        // Assert
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("Buscar alumno por un id que no existe y ver que levante excepcion")
    public void test_findStudentByUnexistentId() {
        // Arrange
        Long id = 9999L;
        // Act + Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    @DisplayName("Borrar un alumno y ver que buscarlo levante excepcion")
    public void test_deleteStudentAndSeeThatItsNoLongerInRepository() {
        // Arrange
        Long id = 1L;
        // Act
        studentDAO.delete(id);
        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    @DisplayName("Ver que un alumno existe")
    public void test_seeThatAStudentExists() {
        // Arrange
        Long id = 1L;
        // Act
        Boolean res = studentDAO.delete(id);
        // Assert
        Assertions.assertTrue(res);
    }

    @Test
    @DisplayName("Ver que un alumno no existe")
    public void test_seeThatAStudentDoesNotExists() {
        // Arrange
        Long id = 999999L;
        // Act
        Boolean res = studentDAO.delete(id);
        // Assert
        Assertions.assertFalse(res);
    }
}
