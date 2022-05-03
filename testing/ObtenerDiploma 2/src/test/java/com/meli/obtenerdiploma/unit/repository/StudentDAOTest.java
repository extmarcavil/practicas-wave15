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
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StudentDAOTest {

    IStudentDAO repository;

    @BeforeEach
    void setup(){
        repository = new StudentDAO();
    }


    @Test
    @DisplayName("Guardamos un estudiante con datos validos")
    public void saveCorrect(){
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matemática");
        subjectDTO.setScore(5.0);

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Física");
        subjectDTO1.setScore(9.0);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Química");
        subjectDTO2.setScore(7.0);

        List<SubjectDTO> subjectDTOS = Arrays.asList(subjectDTO, subjectDTO1, subjectDTO2);

        StudentDTO s1 = new StudentDTO(3L, "Jose", null, 7.0, subjectDTOS);


    }

    @Test
    @DisplayName("Guardamos un estudiante null")
    public void saveIncorrect(){
        Assertions.assertThrows(NullPointerException.class, () -> repository.save(null));
    }

    @Test
    @DisplayName("Encontramos el estudiante si pasamos un ID valido")
    void findByIDWithCorrectID(){
        // arrange
        Long studentID = 1L;

        StudentDTO s1 = new StudentDTO();
        s1.setId(1l);
        s1.setStudentName("Juan");

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matemática");
        subjectDTO.setScore(9.0);

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Física");
        subjectDTO1.setScore(7.0);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Química");
        subjectDTO2.setScore(6.0);

        List<SubjectDTO> subjectDTOS = Arrays.asList(subjectDTO, subjectDTO1, subjectDTO2);
        s1.setSubjects(subjectDTOS);

        // act
        StudentDTO result = repository.findById(studentID);

        // assert
        Assertions.assertEquals(s1, result);
    }

    @Test
    @DisplayName("Encontramos el estudiante si pasamos solo un ID valido")
    public void findByIDWithCorrectIDV2(){
        StudentDTO result = repository.findById(2L);
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("No encontramos el estudiante si pasamos un ID null")
    void notFoundFindByID(){
        // arrange
        Long studentId = null;

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,  () -> repository.findById(studentId));

    }

    @Test
    @DisplayName("No encontramos el estudiante si pasamos un ID null comparando estados")
    void notFoundFindByIDStatus(){
        // arrange
        Long studentId = null;

        // act & assert
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class,  () -> repository.findById(studentId));
        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());

    }

    @Test
    @DisplayName("No encontramos el estudiante si pasamos un ID invalido")
    void notFoundFindByIDWithCorrectID(){
        // arrange
        Long studentId = 3L;

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> repository.findById(studentId));
    }

    @Test
    @DisplayName("Eliminar un estudiante con ID valido")
    public void deleteStudentByIdSuccessfully(){
        //arrange
        Long studentId = 1L;

        //act & assert
        Assertions.assertTrue(repository.delete(studentId));
    }
    @Test
    @DisplayName("Eliminar un estudiante con ID invalido")
    public void deleteNonExistentStudentById(){
        //arrange
        Long studentId = 4L;

        //act & assert
        Assertions.assertFalse(repository.delete(studentId));
    }


}
