package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.utils.SchoolFactory;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    IStudentDAO repository;

    @BeforeEach
    void setup() {
        repository = new StudentDAO();
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

    @Test
    @DisplayName("Create a student successfully")
    void createStudentSuccess() {
        // Arrange
        Set<StudentDTO> expected = SchoolFactory.getAllStudents();
        StudentDTO newStudent = StudentFactory.studentMaria();
        expected.add(newStudent);

        // Act
        repository.save(newStudent);
        Set<StudentDTO> result = repository.findAll();
        StudentDTO studentAdded = repository.findById(newStudent.getId());

        // Assert
        assertAll(
                () -> assertEquals(expected, result, "The lists are differents"),
                () -> assertEquals(expected.size(), result.size(), "The lists has different size"),
                () -> assertEquals(newStudent, studentAdded, "The student added has different id")
        );
    }

    @Test
    @DisplayName("Create a null student")
    void createNullStudent() {
        // Act and assert
        assertThrows(NullPointerException.class, () -> repository.save(null),
                "The exception was not thrown");
    }

    @Test
    @DisplayName("Find student by id")
    void findStudentByIdSuccess() {
        // Arrange
        Long id = 1L; // Id of Juan
        StudentDTO expected = StudentFactory.studentJuan();

        // Act
        StudentDTO result = repository.findById(id);

        // Assert
        assertEquals(expected, result, "The students are different");
    }

    @Test
    @DisplayName("Find student by an id that dosen't exist.")
    void FindStudentByIdNotFound() {
        // Arrange
        Long id = 100L;

        // Act and Assert
        assertThrows(StudentNotFoundException.class, () -> repository.findById(id),
                "The exception was not thrown");
    }

    @Test
    @DisplayName("Find student by an null id.")
    void FindAlumnByIdNull() {
        // Act and Assert
        assertThrows(StudentNotFoundException.class, () -> repository.findById(null),
                "The exception was not thrown");
    }

    @Test
    @DisplayName("Find a student")
    void existStudentSuccess() {
        // Arrange
        StudentDTO expected = StudentFactory.studentJuan();

        // Act and assert
        assertTrue(repository.exists(expected), "Student not found");
    }

    @Test
    @DisplayName("Find a student that dosen't exist")
    void existStudentNotFound() {
        // Arrange
        StudentDTO expected = StudentFactory.studentMaria();

        // Act and assert
        assertFalse(repository.exists(expected), "Student found");
    }

    @Test
    @DisplayName("Find a null student")
    void existStudentWithNull() {
        // Act and assert
        assertThrows(NullPointerException.class, () -> repository.exists(null),
                "The exception was not thrown");
    }

    @Test
    @DisplayName("Edit a student successfully")
    void editStudentSuccess() {
        // Arrange
        Set<StudentDTO> expected = new HashSet<>();

        expected.add(StudentFactory.studentJuan());
        StudentDTO modified = StudentFactory.studentPedroModified();
        expected.add(modified);

        // Act
        repository.save(modified);
        Set<StudentDTO> result = repository.findAll();
        StudentDTO modifiedStudent = repository.findById(modified.getId());

        // Assert
        assertAll(
                () -> assertEquals(expected, result, "The lists are different"),
                () -> assertEquals(expected.size(), result.size(), "The lists has different size"),
                () -> assertEquals(modifiedStudent, modified, "The students modified are different")
        );
    }

    @Test
    @DisplayName("Edit a null student")
    void editStudentAsNull() {
        // Assert
        assertThrows(NullPointerException.class, () -> repository.save(null),
                "The exception was not thrown");
    }

    @Test
    @DisplayName("Delete a student successfully")
    void deleteStudentSuccess() {
        // Arrange
        Set<StudentDTO> expected = SchoolFactory.getAllStudents();
        expected.remove(StudentFactory.studentPedro());

        // Act
        boolean deleteResult = repository.delete(2L);
        Set<StudentDTO> result = repository.findAll();

        // Assert
        assertAll(
                () -> Assertions.assertTrue(deleteResult, "Student not deleted"),
                () -> assertEquals(expected, result, "The list are different"),
                () -> assertEquals(expected.size(), result.size(), "The list has different size"),
                () -> assertThrows(StudentNotFoundException.class, () -> repository.findById(2L),
                        "The exception was not thrown")
        );
    }

    @Test
    @DisplayName("Delete a null student")
    void deleteStudentAsNull() {
        // Act and assert
        assertFalse(repository.delete(null), "The student was deleted");
    }
}
