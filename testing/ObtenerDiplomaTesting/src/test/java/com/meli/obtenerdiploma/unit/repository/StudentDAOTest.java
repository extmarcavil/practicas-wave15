package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDAOTest {

    IStudentDAO studentDAO;
    IStudentRepository studentRepository;

    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
        studentRepository = new StudentRepository();
    }


    @Test
    @DisplayName("Buscar un alumno por ID correcto")
    void buscarAlumnoPorIdOk(){
        // Arrange
        Long id = 8L;
        //StudentDTO student;

        // Act
        StudentDTO student = studentDAO.findById(id);

        // Assert
        Assertions.assertNotNull(student);
    }

    @Test
    @DisplayName("Buscar un alumno por ID incorrecto")
    void buscarAlumnoPorIdNotOk(){
        // Arrange
        Long id = 777L;
        ;
        // Assert & Act

        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    @DisplayName("Verificar si existe el estudiante.")
    void estudianteExiste(){
        //Arrange
        StudentDTO stu = new StudentDTO();
        stu.setId(1L);

        //Act
        boolean result = this.studentDAO.exists(stu);

        //assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Verificar que no exista el estudiante")
    void estudianteNoExiste(){
        //Arrange
        StudentDTO stu = new StudentDTO();
        stu.setId(-1L);

        //Act
        boolean result = this.studentDAO.exists(stu);

        //assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Eliminar un estudiante y verificar que se eliminó.")
    public void deleteStudent() {
        // Arrange
        Long id = 1L;

        // Act
        this.studentDAO.delete(id);

        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> this.studentDAO.findById(id));
    }
}
