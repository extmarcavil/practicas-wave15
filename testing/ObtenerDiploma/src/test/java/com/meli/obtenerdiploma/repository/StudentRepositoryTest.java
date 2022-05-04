package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentRepositoryTest {

    IStudentRepository repository;

    @BeforeEach
    void setup(){
        repository = new StudentRepository();
    }

    @Test
    @DisplayName("obtener todos los registros")
    void findAllStudentsTest() {
        Set<StudentDTO> students = repository.findAll();

        Set<StudentDTO> studentsExpected = new HashSet<>();

        List<SubjectDTO> juanSubjects = new ArrayList<>();
        juanSubjects.add(new SubjectDTO("Matemática", 9.0));
        juanSubjects.add(new SubjectDTO("Física", 7.0));
        juanSubjects.add(new SubjectDTO("Química", 6.0));
        StudentDTO juan = new StudentDTO(1L, "Juan", null, null, juanSubjects);

        List<SubjectDTO> pedroSubjects = new ArrayList<>();
        pedroSubjects.add(new SubjectDTO("Matemática", 10.0));
        pedroSubjects.add(new SubjectDTO("Física", 8.0));
        pedroSubjects.add(new SubjectDTO("Química", 4.0));
        StudentDTO pedro = new StudentDTO(2L, "Pedro", null, null, pedroSubjects);

        studentsExpected.add(pedro);
        studentsExpected.add(juan);

        assertFalse(students.isEmpty());
        assertEquals(students, studentsExpected);
    }
}
