package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.utils.StudentFactory;
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
    static StudentDAO dao = new StudentDAO();

    @BeforeEach
    void setup(){
        repository = new StudentRepository();
    }

    @Test
    @DisplayName("obtener todos los registros")
    void findAllStudentsTest() {
        Set<StudentDTO> students = repository.findAll();

        System.out.println("studwnts: " + students);

        Set<StudentDTO> studentsExpected = StudentFactory.getAllStudents();

        assertFalse(students.isEmpty());
        assertEquals(studentsExpected, students);
    }
}
