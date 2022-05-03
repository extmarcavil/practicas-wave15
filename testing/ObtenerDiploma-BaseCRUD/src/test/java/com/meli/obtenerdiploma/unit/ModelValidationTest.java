package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ModelValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void createStudentWithoutSubjects(){

        //arrange
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, null );

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertEquals(validations.size(), 1);
    }

    @Test
    public void createStudentWithEmptySubjects(){
        //arrange
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, new ArrayList<>());

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertEquals(validations.size(), 1);
    }
    @Test
    public void createStudentWithoutName(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", 8d);
        StudentDTO studentDTO = new StudentDTO(null, null, null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertEquals(validations.size(), 1);
    }

    @Test
    public void createStudentWithEmptyName(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", 8d);
        StudentDTO studentDTO = new StudentDTO(null, "", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentWithNegativeSubjectNote(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", -0.9d);
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentWithSubjectNoteMayorThan10(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", 10.1);
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentWithInvalidSubjectName(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("aHistoria", 8d);
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentWithEmptySubjectName(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("", 8d);
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentWithoutSubjectName(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO(null, 8d);
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentWithoutSubjectNote(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", null);
        StudentDTO studentDTO = new StudentDTO(null, "Tomas", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentWithInvalidName(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", 8d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertNotEquals(validations.size(), 0);
    }

    @Test
    public void createStudentSuccessfully(){
        //arrange
        SubjectDTO subjectDTO = new SubjectDTO("Historia", 8d);
        StudentDTO studentDTO = new StudentDTO(null, "Test", null, null, List.of(subjectDTO));

        //act
        Set<ConstraintViolation<StudentDTO>> validations = validator.validate(studentDTO);

        //assert
        assertEquals(validations.size(), 0);
    }
}
