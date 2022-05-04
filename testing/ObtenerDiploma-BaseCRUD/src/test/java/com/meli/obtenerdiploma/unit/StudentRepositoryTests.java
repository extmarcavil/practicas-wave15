package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTests {

    static private IStudentRepository studentRepository;

    @BeforeAll
    static void initialSetUp(){
        studentRepository = new StudentRepository();
    }

    @Test
    public void findAllStudents(){
        //arrange

        //act
        Set<StudentDTO> students = studentRepository.findAll();

        //assert
        assertEquals(students.size(), 3);
    }
}
