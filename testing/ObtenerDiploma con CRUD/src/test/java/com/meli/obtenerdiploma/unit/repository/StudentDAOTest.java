package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StudentDAOTest {
    IStudentDAO dao;

    @BeforeEach
    void setup(){
        dao = new StudentDAO();
    }

    @Test
    @DisplayName("Existe el estudiante - Verdadero")
    void existsTrue(){
        //arrange
        StudentDTO stu = new StudentDTO();
        stu.setId(2L);

        //act
        boolean result = this.dao.exists(stu);

        //assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Existe el estudiante - Falso")
    void existsFalse(){
        //arrange
        StudentDTO stu = new StudentDTO();
        stu.setId(4L);

        //act
        boolean result = this.dao.exists(stu);

        //assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Agregar un estudiante y validar que se agregó")
    public void saveStudent() {
        // Arrange
        SubjectDTO matematica = new SubjectDTO("Matematica", 9.0);
        SubjectDTO ingles = new SubjectDTO("Inglés",8.0);

        StudentDTO stu = new StudentDTO(3L, "Carla", "Estudiante aprobado",
                8.5, Arrays.asList(matematica, ingles));

        // Act
        this.dao.save(stu);

        // Assert
        Assertions.assertTrue(this.dao.exists(stu));
    }

    @Test
    @DisplayName("Buscar estudiante por id - Existe")
    public void findByExistingId() {
        // Arrange
        Long id = 2L;

        // Act
        StudentDTO result = this.dao.findById(id);

        // Assert
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("Buscar estudiante por id - No existe")
    public void findByNonExistingId() {
        // Arrange
        Long id = 10L;

        // Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> this.dao.findById(id));
    }

    @Test
    @DisplayName("Eliminar un estudiante y validar que se eliminó.")
    public void deleteStudent() {
        // Arrange
        Long id = 1L;

        // Act
        this.dao.delete(id);

        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> this.dao.findById(id));
    }
}
