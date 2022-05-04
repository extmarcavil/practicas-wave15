package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    StudentService mockStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Comprobar resultado codigo 200 al realizar registro de un estudiante")
    void registerStudentOk(){
        // arrange
        StudentDTO studentDTO = new StudentDTO();
                //StudentFactory.createStudentOne();
        // act & mock
        doNothing().when(mockStudentService).create(studentDTO);
        ResponseEntity<?> result = studentController.registerStudent(studentDTO);
        // assert
        verify(mockStudentService, times(1)).create(studentDTO);
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    @DisplayName("buscar un estudiante por Id valido")
    void getStudentByIdOk(){
        // arrange
        Long id = 2L;
        StudentDTO expected = StudentFactory.getStudentPedroInJson();
        // act & mock
        when(mockStudentService.read(id)).thenReturn(expected);
        StudentDTO result = studentController.getStudent(id);
        // assert
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Comprobar resultado codigo 200 al actualizar datos de un estudiante")
    void modifyStudentOk(){
        // arrange
        StudentDTO studentDTO = StudentFactory.getStudentPedroInJson();
        studentDTO.getSubjects().get(0).setScore(7.0);
        // act & mock
        doNothing().when(mockStudentService).update(studentDTO);
        ResponseEntity<?> result = studentController.modifyStudent(studentDTO);
        // assert
        verify(mockStudentService, times(1)).update(studentDTO);
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    @DisplayName("Comprobar resultado codigo 200 al eliminar un estudiante")
    void removeStudentOk(){
        // arrange
        Long id = 1L;
        // act & mock
        doNothing().when(mockStudentService).delete(id);
        ResponseEntity<?> result = studentController.removeStudent(id);
        // assert
        verify(mockStudentService, times(1)).delete(id);
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    @DisplayName("listar todos los alumnos")
    void listStudentsValid(){
        // arrange
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(StudentFactory.getStudentJuanInJson());
        expected.add(StudentFactory.getStudentPedroInJson());

        // act
        when(mockStudentService.getAll()).thenReturn(expected);
        // assert
        Set<StudentDTO> result = studentController.listStudents();
        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertEquals(expected, result)

        );
    }

}
