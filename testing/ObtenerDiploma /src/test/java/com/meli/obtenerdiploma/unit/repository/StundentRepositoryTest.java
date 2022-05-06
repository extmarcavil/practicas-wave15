package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.utils.MakeStudentsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StundentRepositoryTest {
    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
        studentRepo=new StudentRepository();
    }

    @Test
    @DisplayName("Listar todos los alumnos")
    public void listarTodosLosAlumnos(){

        //arrange
        Set<StudentDTO> expected = MakeStudentsDTO.getStudentSet();

        //act
        Set<StudentDTO> actual = studentRepo.findAll();

        //assert
        Assertions.assertEquals(expected,actual);
    }

}

//Set<StudentDTO> getStudentSet()