package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StudentDAOTest {
    private IStudentDAO studentDAO;
    private  StudentDTO newStudentDTO;

    public StudentDAOTest() {
        this.studentDAO = new StudentDAO();
        var listSubjects = new ArrayList<SubjectDTO>();
        listSubjects.add(new SubjectDTO("Matematicas",9.0));
        newStudentDTO = new StudentDTO(2L,"Gerson","",0.0,listSubjects);
    }

    @Test
    @DisplayName(" se dio de alta un nuevo alumno")
    void newStudent(){
       studentDAO.save(newStudentDTO);
       Assertions.assertTrue(studentDAO.exists(newStudentDTO));
    }

    @Test
    @DisplayName(" no existe el alumno 123")
    void notExistStudent(){
        var id = 123L;
       Assertions.assertThrows(StudentNotFoundException.class,() -> {studentDAO.findById(id);});
    }

    @Test
    @DisplayName(" existe el alumno 2")
    void existStudent(){
        var id = 2L;
        Assertions.assertEquals(StudentDTO.class,studentDAO.findById(id).getClass());
    }

    @Test
    @DisplayName(" actualiza datos del alumno 2")
    void updateInfoStudent(){
        var whereStudent = studentDAO.findById(2L);
        whereStudent.setStudentName(whereStudent.getStudentName() + " jair sanchez arroyo");
        Assertions.assertEquals("Gerson jair sanchez arroyo" ,studentDAO.findById(whereStudent.getId()).getStudentName());
    }

    @Test
    @DisplayName(" se elimina el alumno 2")
    void deleteStudent(){
        Assertions.assertTrue(studentDAO.delete(2L));
    }

    @Test
    @DisplayName(" no se elimina el alumno 20,porque no existe")
    void deleteStudentNotExist(){
        Assertions.assertFalse(studentDAO.delete(20L));
    }

    @Test
    @DisplayName(" se obtiene lista de alumnos")
    void getStudents(){
        Assertions.assertTrue(studentDAO.allStudents().size() > 0);
    }

}
