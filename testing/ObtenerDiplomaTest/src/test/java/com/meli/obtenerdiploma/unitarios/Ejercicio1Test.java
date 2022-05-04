package com.meli.obtenerdiploma.unitarios;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.meli.obtenerdiploma.utilidades.Utils.*;

public class Ejercicio1Test {
    IStudentDAO sdao;
    IStudentRepository srepo;

    @BeforeEach
    void setup(){
        sdao = new StudentDAO();
        srepo = new StudentRepository();
    }

    @Test
    void agregarUnAlumnoTest() {
        StudentDTO student = newStudent(1l, "jose");

        sdao.save(student);
        Assertions.assertTrue(sdao.exists(student));
        sdao.delete(student.getId());
    }

    @Test
    void eliminarUnAlumnoQueExisteTest() {
        StudentDTO student = newStudent(1l, "jose");

        sdao.save(student);

        Assertions.assertTrue(sdao.exists(student));

        Assertions.assertTrue(sdao.delete(student.getId()));
        Assertions.assertFalse(sdao.exists(student));
    }

    @Test
    void eliminarUnAlumnoQueNoExisteTest() {
        Assertions.assertFalse(sdao.delete(1l));
    }

    @Test
    void listarTodosLosAlumnosTest() {
        StudentDTO student = newStudent(1l, "jose");
        StudentDTO student2 = newStudent(2l, "pepe");

        sdao.save(student);
        sdao.save(student2);

        Assertions.assertEquals(Arrays.asList(student, student2), srepo.findAll().stream().collect(Collectors.toList()));

        sdao.delete(student.getId());
        sdao.delete(student2.getId());
    }
}
