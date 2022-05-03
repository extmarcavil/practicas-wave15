package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;

    private StudentDTO student;

    @BeforeEach
    void setUp() {
        student = new StudentDTO();
        student.setStudentName("Pepe");
    }

    @Test
    void validateStudentWasSavedSuccessfully() {
        studentDAO.save(student);
        StudentDTO studentDtoExpected = studentDAO.findById(student.getId());

        assertThat(studentDtoExpected.getStudentName()).isEqualTo(student.getStudentName());
    }

    @Test
    void whenTheSearchingStudentNotExists_thenAnExceptionIsThrown() {
        long idNoExists = 10L;

        assertThrows(ObtenerDiplomaException.class, () -> studentDAO.findById(idNoExists));
    }

}
