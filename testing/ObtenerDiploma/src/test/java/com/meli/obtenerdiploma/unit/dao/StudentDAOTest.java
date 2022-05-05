package com.meli.obtenerdiploma.unit.dao;

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

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    void setup(){studentDAO = new StudentDAO();}

    @Test
    @DisplayName("Creamos un estudiante valido")
    public void saveSuccess(){
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Filosofía", 6.0));
        subjectList.add(new SubjectDTO("Dibujo", 6.0));
        StudentDTO student = new StudentDTO(null, "Pepe", "intermedio", 6.0, subjectList);

        studentDAO.save(student);

        Assertions.assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Creamos un estudiante null")
    public void saveUnsuccess(){
        Assertions.assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    @DisplayName("Buscar un estudiante con un id correcto")
    public void findById(){
      StudentDTO student = studentDAO.findById(1L);
        Assertions.assertNotNull(student);
    }

    @Test
    @DisplayName("Buscar un estudiante con un id incorrecto")
    public void findByIdNull(){
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(3L));
        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

    @Test
    @DisplayName("Eliminar un estudiante")
    public void delete(){
        studentDAO.delete(2L);

        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(2L));
        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

}
