package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.utils.StudentsFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {

    private IStudentDAO studentDAO;

    @BeforeEach
    public void setup() {
        studentDAO = new StudentDAO();
    }


    @Test
    public void saveStudentWithCorrectData() {
        List<SubjectDTO> subjects = new ArrayList<>() {{
            add(new SubjectDTO("Matematicas", 3.5));
            add(new SubjectDTO("Ingles", 6.5));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Test");
        student.setMessage("Message");
        student.setSubjects(subjects);


    }

    @Test
    public void saveStudentWithIncorrectData() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>() {{
            add(new SubjectDTO("matematicas", 3.5));
            add(new SubjectDTO("Ingles", 6.5));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Test");
        student.setMessage("Message");
        student.setSubjects(null);

        // act - assert
        Assertions.assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    @DisplayName("Obtener un alumno por un id valido.")
    public void findStudentById() {

        // arrange
        Long validId = 2L;
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setId(validId);
        expectedStudent.setStudentName("Pedro");
        List<SubjectDTO> subjects = StudentsFactory.getSubjects();
        expectedStudent.setSubjects(subjects);


        // act
        StudentDTO student = studentDAO.findById(validId);

        // assert
        Assertions.assertEquals(expectedStudent, student);
    }

    @Test
    @DisplayName("Obtener un alumno por un id invalido.")
    public void findStudentByInvalidId() {

        // arrange
        Long validId = 3L;

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(validId));
    }

    @Test
    @DisplayName("Obtener un alumno por un id nulo.")
    public void findStudentByNullId() {

        // arrange
        Long validId = null;

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(validId));
    }

    @Test
    @DisplayName("Actualizar datos de un estudiante de manera correcta.")
    public void updateStudentWithCorrectData() {

        // arrange
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Test");
        student.setMessage("Message 2");

        // act
        studentDAO.save(student);
        StudentDTO studentResult = studentDAO.findById(1L);

        //assert
        Assertions.assertEquals(student, studentResult);
    }

    @Test
    @DisplayName("Actualizar datos de un estudiante con datos nulos.")
    public void updateStudentWithNullData() {

        // arrange
        StudentDTO student = null;

        // act & assert
        Assertions.assertThrows(NullPointerException.class, () -> studentDAO.save(student));
    }

    @Test
    @DisplayName("Actualizar datos de un estudiante con datos vacios.")
    public void updateStudentWithEmptyData() {

        // arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("");
        student.setMessage("");

        // act
        studentDAO.save(student);
        StudentDTO studentResult = studentDAO.findById(1L);

        //assert
        Assertions.assertEquals(true, studentDAO.exists(student));
    }

    @Test
    @DisplayName("Eliminar un usuario existente")
    public void deleteExistingUser() {

        // arrange
        Long validId = 1L;

        // act
        boolean result = studentDAO.delete(validId);

        // assert
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Eliminar un usuario no existente")
    public void deleteNonExistingUser() {

        // arrange
        Long validId = 3L;

        // act
        boolean result = studentDAO.delete(validId);

        // assert
        Assertions.assertFalse(result);
    }

}
