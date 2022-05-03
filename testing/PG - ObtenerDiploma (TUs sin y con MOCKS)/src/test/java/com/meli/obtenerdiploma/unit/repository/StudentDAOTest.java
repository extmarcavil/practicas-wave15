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
import java.util.List;

//EJERCICIO 1 - TU SIN MOCK

public class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Agregando un alumno nuevo con los datos correctos.")
    void cargarAlumnoOk(){
        //Arrange
        SubjectDTO matematica = new SubjectDTO("Matemática", 9.0);
        SubjectDTO lengua = new SubjectDTO("Lengua", 6.0);
        SubjectDTO edFisica = new SubjectDTO("Educación Física", 8.0);
        List<SubjectDTO> materias = Arrays.asList(matematica, lengua, edFisica);
        StudentDTO expected = new StudentDTO(null, "Gonzalo", null, null, materias);

        //Act
        studentDAO.save(expected);

        //Assert
        Assertions.assertTrue(studentDAO.exists(expected));
    }

    /*@Test
    @DisplayName("Agregando un alumno nuevo con los datos incorrectos.")
    void cargarAlumnoNotOk(){
        //Arrange
        SubjectDTO matematica = new SubjectDTO(null, 9.0);
        SubjectDTO lengua = new SubjectDTO("lengua", 6.0);
        SubjectDTO edFisica = new SubjectDTO("educación Física", 48.0);
        List<SubjectDTO> materias = Arrays.asList(matematica, lengua, edFisica);
        StudentDTO expected = new StudentDTO(null, "jonzalo", null, null, materias);

        //Act
        studentDAO.save(expected);

        //Assert
        Assertions.assertFalse(studentDAO.exists(expected));
    }*/

    @Test
    @DisplayName("Buscar un alumno por ID correcto")
    void buscarAlumnoPorIdOk(){
        // Arrange
        Long id = 1L;
        StudentDTO student;
        // Act

        student = studentDAO.findById(id);

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
