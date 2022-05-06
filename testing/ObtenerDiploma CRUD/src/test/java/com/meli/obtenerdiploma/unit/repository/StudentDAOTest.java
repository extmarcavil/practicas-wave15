package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {
    IStudentDAO iStudentDAO;

    @BeforeEach
    void setup(){
        iStudentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Miramos si guarda correctamente")
    void SaveStudent(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);

        iStudentDAO.save(studentDTO);
    }

    @Test
    @DisplayName("Miramos comportamiento al guardar estudiante en NULL")
    void SaveStudentNull(){
        StudentDTO studentDTO = null;
        Assertions.assertThrows(NullPointerException.class, () -> iStudentDAO.save(studentDTO));
    }

    @Test
    @DisplayName("Miramos comportamiento al guardar estudiante vacío")
    void SaveStudentVoid(){
        StudentDTO studentDTO = new StudentDTO();
        iStudentDAO.save(studentDTO);
    }

    @Test
    @DisplayName("Miramos si busca correctamente")
    void FindStudent(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);

        iStudentDAO.save(studentDTO);
    }

    @Test
    @DisplayName("Miramos comportamiento al guardar estudiante en NULL")
    void FindStudentNull(){
        StudentDTO studentDTO = null;
        Assertions.assertThrows(NullPointerException.class, () -> iStudentDAO.save(studentDTO));
    }

    @Test
    @DisplayName("Miramos comportamiento al guardar estudiante vacío")
    void FindStudentVoid(){
        StudentDTO studentDTO = new StudentDTO();
        iStudentDAO.save(studentDTO);
    }
}
