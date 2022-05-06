package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class StudentDAOTest {
    private static IStudentDAO studentDAO;

    @BeforeAll
    static void setup() {
        studentDAO = new StudentDAO();
    }

    @Test
    public void save_studentDTO() {
        // Arrange
        StudentDTO student = new StudentDTO();
        int expectedId = 3;
        // Act
        studentDAO.save(student);
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(studentDAO.exists(student)),
                () -> Assertions.assertEquals(expectedId, student.getId())
        );
    }

    @Test
    public void delete_existing() {
        // Arrange
        StudentDTO student = new StudentDTO();
        Long studentId = 3L;
        student.setId(studentId);
        studentDAO.save(student);
        // Act
        studentDAO.delete(studentId);
        // Assert
        Assertions.assertFalse(studentDAO.exists(student));
    }

    @Test
    public void delete_nonExisting() {
        // Arrange
        Long studentId = 4L;
        // Act / Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.delete(studentId));
    }

    @Test
    public void exists_existing() {
        // Arrange
        Long studentId = 1L;
        // Act / Assert
        Assertions.assertDoesNotThrow(() -> studentDAO.exists(studentDAO.findById(studentId)));
    }

    @Test
    public void exists_nonExisting() {
        // Arrange
        Long studentId = 10L;
        // Act / Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.exists(studentDAO.findById(studentId)));

    }
}