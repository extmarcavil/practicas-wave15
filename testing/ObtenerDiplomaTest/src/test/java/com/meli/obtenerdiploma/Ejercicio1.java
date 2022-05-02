package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    IStudentDAO sdao;
    IStudentRepository srepo;

    @BeforeEach
    void setup(){
        sdao = new StudentDAO();
        srepo = new StudentRepository();
    }

    @Test
    void agregarUnAlumnoTest() {
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 6.0));
        subjects.add(new SubjectDTO("historia", 7.0));

        StudentDTO student = new StudentDTO(1l, "Jose", "mensaje", 8.0, subjects);

        sdao.save(student);

        Assertions.assertTrue(sdao.exists(student));

        sdao.delete(student.getId());
    }

    @Test
    void eliminarUnAlumnoQueExisteTest() {
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 6.0));
        subjects.add(new SubjectDTO("historia", 7.0));

        StudentDTO student = new StudentDTO(1l, "Jose", "mensaje", 8.0, subjects);

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
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 6.0));
        subjects.add(new SubjectDTO("historia", 7.0));

        StudentDTO student = new StudentDTO(1l, "Jose", "mensaje", 8.0, subjects);
        StudentDTO student2 = new StudentDTO(2l, "Pepe", "mensaje", 9.0, subjects);

        sdao.save(student);
        sdao.save(student2);

        Assertions.assertEquals(Arrays.asList(student, student2), srepo.findAll().stream().collect(Collectors.toList()));

        sdao.delete(student.getId());
        sdao.delete(student2.getId());
    }
}
