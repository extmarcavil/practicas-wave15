package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
class StudentControllerTest {

    @Mock
    private StudentService studentService;
    @Mock
    private StudentDAO repository;

    @InjectMocks
    private StudentController controller;

    private StudentDTO student;

    @BeforeEach
    void setUp() {
        student = new StudentDTO();
        student.setId(1l);
        student.setStudentName("Pepe");
        repository.save(student);
    }

    @Test
    void validateStudentWasSavedSuccessfullyAndResponseEntityIs200() {
        ResponseEntity<?> response = controller.registerStudent(student);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void validateStudentDoesNotExistWhenTryRegister() {
        doThrow(new StudentNotFoundException(student.getId()))
                .doNothing()
                .when(studentService).create(student);

        StudentNotFoundException exception = assertThrows(StudentNotFoundException.class, () -> {
            controller.registerStudent(student);
        });

        assertThatThrownBy(() -> controller.registerStudent(student))
                .isInstanceOf(StudentNotFoundException.class);
    }
}