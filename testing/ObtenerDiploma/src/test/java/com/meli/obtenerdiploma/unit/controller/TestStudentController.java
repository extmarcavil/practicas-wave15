package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class TestStudentController {
    @Mock
    private IStudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("registerStudent debe llamar al create del service")
    public void test_registerStudentCallsServiceCreate() {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();

        // When
        studentController.registerStudent(s);

        // Then
        Mockito.verify(studentService).create(s);
    }

    @Test
    @DisplayName("registerStuden debe devolver Response Entity OK")
    public void test_registerStudentMustReturnResponseEntityOK() {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();

        // When
        ResponseEntity<?> result = studentController.registerStudent(s);

        // Then
        Assertions.assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    @DisplayName("getStudent debe retornar lo mismo que retorna el service")
    public void test_getStudentMustReturnWhateverTheServiceReturns() {
        // Given
        Long id = 25L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        Mockito.when(studentService.read(id)).thenReturn(s);

        // When
        StudentDTO result = studentController.getStudent(id);

        // Then
        Assertions.assertEquals(s, result);
    }

    @Test
    @DisplayName("modifyStudent debe llamar al update del service")
    public void test_modifyStudentCallsServiceUpdate() {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();

        // When
        studentController.modifyStudent(s);

        // Then
        Mockito.verify(studentService).update(s);
    }

    @Test
    @DisplayName("modifyStudent debe devolver Response Entity OK")
    public void test_modifyStudentMustReturnResponseEntityOK() {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();

        // When
        ResponseEntity<?> result = studentController.modifyStudent(s);

        // Then
        Assertions.assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    @DisplayName("removeStudent debe llamar al delete del service")
    public void test_deleteStudentCallsServiceDelete() {
        // Given
        Long id = 9L;

        // When
        studentController.removeStudent(id);

        // Then
        Mockito.verify(studentService).delete(id);
    }

    @Test
    @DisplayName("removeStudent debe devolver Response Entity OK")
    public void test_removeStudentMustReturnResponseEntityOK() {
        // Given
        Long id = 9L;

        // When
        ResponseEntity<?> result = studentController.removeStudent(id);

        // Then
        Assertions.assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    @DisplayName("listStudents debe retornar lo mismo que retorna el service")
    public void test_listStudentsMustReturnWhateverTheServiceReturns() {
        // Given
        Set<StudentDTO> s = Set.of(StudentFactory.createStraightAStudent());
        Mockito.when(studentService.getAll()).thenReturn(s);

        // When
        Set<StudentDTO> result = studentController.listStudents();

        // Then
        Assertions.assertEquals(s, result);
    }
}
