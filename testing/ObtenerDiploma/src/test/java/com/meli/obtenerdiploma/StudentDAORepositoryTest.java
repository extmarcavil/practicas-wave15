package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;


public class StudentDAORepositoryTest {

    private IStudentDAO repository;

    @BeforeEach
    void setUp() {
        this.repository = new StudentDAO();
    }

    @AfterEach
    void clean() { this.repository.delete(1L); }


    @Test
    @DisplayName("Save student")
    void saveStudent() {

        // Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setId(1L);
        studentToSave.setStudentName("Nicolas");

        // Act
        repository.save(studentToSave);

        // Assert
        Assertions.assertTrue(repository.exists(studentToSave));
    }

    @Test
    @DisplayName("Find student by id")
    void findStudentById() {

        // Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setId(1L);
        repository.save(studentToSave);

        // Act
        StudentDTO student = repository.findById(studentToSave.getId());

        // Assert
        Assertions.assertEquals(studentToSave, student);
    }

    @Test
    @DisplayName("Edit student")
    void editStudent() {

        // Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setId(1L);
        studentToSave.setStudentName("Juan");
        repository.save(studentToSave);

        // Act
        StudentDTO editStudent = repository.findById(1L);
        editStudent.setStudentName("Pepe");
        repository.save(editStudent);

        // Assert
        Assertions.assertEquals("Pepe", repository.findById(1L).getStudentName());
    }

    @Test
    @DisplayName("Delete student by id")
    void deleteStudentById() {

        // Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setId(1L);
        repository.save(studentToSave);

        // Act
        repository.delete(1L);

        // Assert
        Assertions.assertFalse(repository.exists(studentToSave));
    }


}
