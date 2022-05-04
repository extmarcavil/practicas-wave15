package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StudentRepositoryTest {
    IStudentRepository repository;

    @BeforeEach
    void setup(){
        repository = new StudentRepository();
    }

    @Test
    @DisplayName("Obtener todos los estudiantes")
    void findAll(){
        // arrange
/*
        Datos para comprobar si los valores son iguales.
        SubjectDTO matematicaJuan = new SubjectDTO();
        matematicaJuan.setName("Matemática");
        matematicaJuan.setScore(9.0);

        SubjectDTO fisicaJuan = new SubjectDTO();
        fisicaJuan.setName("Física");
        fisicaJuan.setScore(7.0);

        SubjectDTO quimicaJuan = new SubjectDTO();
        quimicaJuan.setName("Química");
        quimicaJuan.setScore(6.0);


        List<SubjectDTO> subjectsJuan = Arrays.asList(matematicaJuan, fisicaJuan, quimicaJuan);

        StudentDTO juan = new StudentDTO();
        juan.setId(1L);
        juan.setStudentName("Juan");
        juan.setSubjects(subjectsJuan);

        SubjectDTO matematicaPedro = new SubjectDTO();
        matematicaPedro.setName("Matemática");
        matematicaPedro.setScore(10.0);

        SubjectDTO fisicaPedro = new SubjectDTO();
        fisicaPedro.setName("Física");
        fisicaPedro.setScore(8.0);

        SubjectDTO quimicaPedro = new SubjectDTO();
        quimicaPedro.setName("Química");
        quimicaPedro.setScore(4.0);


        List<SubjectDTO> subjectsPedro = Arrays.asList(matematicaPedro, fisicaPedro, quimicaPedro);

        StudentDTO pedro = new StudentDTO();
        pedro.setId(2L);
        pedro.setStudentName("Pedro");
        pedro.setSubjects(subjectsPedro);

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(juan);
        expected.add(pedro);*/

        // act
        Set<StudentDTO> result = repository.findAll();

        // assert
        Assertions.assertNotNull(result);
    }

}
