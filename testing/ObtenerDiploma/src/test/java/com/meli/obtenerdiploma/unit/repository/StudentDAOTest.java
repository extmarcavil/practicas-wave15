package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    //Repository
    IStudentDAO studentDaoRepository;

    //Studnet
    StudentDTO student1;
    StudentDTO student2;


    @BeforeEach
    void setUp() {
        //Repository
        studentDaoRepository = new StudentDAO();

        //Subjects
        SubjectDTO s1 = new SubjectDTO("Prodgramacion Funcional", 8.0);
        SubjectDTO s2 = new SubjectDTO("Test", 9.0);
        SubjectDTO s3 = new SubjectDTO("Software", 5.0);

        //Student
        student1 = new StudentDTO();
        student1.setStudentName("Pablo");
        student1.setAverageScore(8D);
        student1.setMessage("Notes");
        student1.setSubjects(Arrays.asList(s1, s2, s3));

        student2 = new StudentDTO();
        student2.setStudentName("Pablo");
        student2.setAverageScore(8D);
        student2.setMessage("Notes");
        student2.setSubjects(Arrays.asList(s1, s2, s3));

    }


    /**
     * Test Almacenar Un Estudiante
     */
    @DisplayName("Almacenando un estudiante")
    @Test
    void SaveStudentTest() {
        //Arrange
        //Act
        studentDaoRepository.save(student1);
        studentDaoRepository.save(student2);
        boolean existe = studentDaoRepository.exists(student1);
        boolean existe2 = studentDaoRepository.exists(student1);

        //Assert
        assertTrue(existe);
        assertTrue(existe2);

    }

    /**
     * Test Almacenar Un Estudiante nulo
     */
    @DisplayName("Almacenando un estudiante Nulo")
    @Test
    void SaveStudentNullTest() {
        //Arrange
        StudentDTO s = null;

        //Act

        //Assert
        assertThrows(NullPointerException.class, () ->
                studentDaoRepository.save(s));

    }

    /**
     * Test Buscar un estudiante por Id
     */
    @DisplayName("Buscando un estudiante por Id")
    @Test
    void getStudentByIdTest() {
        //Arrange
        Long id = 1L;

        //Act
        StudentDTO student = studentDaoRepository.findById(id);

        //Assert
        assertAll(
                () -> assertNotNull(student, () -> "El estudiante No esta registrado"),
                () -> assertEquals("Juan", student.getStudentName(), () -> "El estudiante no conincide con el nombre esperado"),
                () -> assertEquals(3, student.getSubjects().size(), () -> "El estudiante no cursa la cantidad de materias esperadas")
        );
    }

    /**
     * Test Buscar un estudiante por Id no Almacenado
     */
    @DisplayName("Buscando un estudiante por Id no Almacenado")
    @Test
    void getStudentByIdNoSaveTest() {
        //Arrange
        Long id = 20L;

        //Act

        //Assert
        assertThrows(StudentNotFoundException.class, () ->
                studentDaoRepository.findById(id));
    }

    /**
     * Test Verificar que un Estuduante exista
     */
    @DisplayName("Verificar que un estudiante exista")
    @Test
    void verifyExistStudent() {
        //Arrange
        StudentDTO s = student1;
        s.setId(3L);

        //Act
        boolean existe = studentDaoRepository.exists(s);

        //Assert
        assertTrue(existe);

    }

    /**
     * Test Verificar que un Estuduante NO exista
     */
    @DisplayName("Verificar que un estudiante no Exista")
    @Test
    void verifyNotExistStudent() {
        //Arrange
        StudentDTO s = new StudentDTO();

        //Act

        //Assert
        assertFalse(studentDaoRepository.exists(s), "El estudiante no existe en BD");
    }


    /**
     * Test Eliminar un estudiante.
     */
    @DisplayName("Eliminar un Estudiante")
    @Test
    void deleteStudentTest() {
        //Arrange

        //Act

        //Assert
        assertTrue(studentDaoRepository.delete(2L));
    }

    /**
     * Test Eliminar un estudiante qeu no existe en BD.
     */
    @DisplayName("Eliminar un estudiante qeu no existe en BD")
    @Test
    void deleteNotExistsStudentTest() {
        //Arrange

        //Act

        //Assert
        assertFalse(studentDaoRepository.delete(20L));
    }


}