package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTests {
    static private IStudentDAO studentDAO;

    @BeforeAll
    static void initialSetUp(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void createStudentSuccessfully(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", 8d);
        StudentDTO studentDTO = new StudentDTO(null, "Test", null, null, List.of(subjectDTO));

        //act

        //assert
        assertDoesNotThrow(()->studentDAO.save(studentDTO));
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    public void updateStudentSuccessfully(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", 8d);
        StudentDTO studentDTO = new StudentDTO(100L, "TestEdited", null, null, List.of(subjectDTO));
        //StudentDTO studentFound = studentDAO.findById(100L);
        //assertNotEquals(studentDTO, studentFound);
        //act
        //Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        //assertEquals(validations.size(), 0);
        assertDoesNotThrow(()->studentDAO.save(studentDTO));
        assertTrue(studentDAO.exists(studentDTO));
        //studentFound = studentDAO.findById(100L);
        //assertEquals(studentDTO, studentFound);
    }

    @Test
    public void findExistentStudentById(){
        //arrange

        //act

        //assert
        assertDoesNotThrow(()->studentDAO.findById(2L));
    }

    @Test
    public void findNonExistentStudentById(){
        //arrange

        //act

        //assert
        assertThrows(StudentNotFoundException.class,()->studentDAO.findById(-1L));
    }

    @Test
    public void deleteStudentByIdSuccessfully(){
        //arrange

        //act

        //assert
        assertTrue(studentDAO.delete(1L));
    }

    @Test
    public void deleteNonExistentStudentById(){
        //arrange

        //act

        //assert
        assertFalse(studentDAO.delete(-1L));
    }

}
