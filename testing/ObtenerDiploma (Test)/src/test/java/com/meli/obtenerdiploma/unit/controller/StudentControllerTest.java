package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.SchoolFactory;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    @DisplayName("Save a student")
    public void registerStudent() {
        // Arrange
        StudentDTO student = StudentFactory.studentMaria();

        // Mock
        doNothing().when(service).create(student);

        // Act
        ResponseEntity<?> response = controller.registerStudent(student);

        // Assert
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> verify(service, times(1)).create(student)
        );
    }

    @Test
    @DisplayName("Get a student by id")
    public void getStudent() {
        // Arrange
        StudentDTO student = StudentFactory.studentJuan();

        // Mock
        when(service.read(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = controller.getStudent(student.getId());

        // Assert
        assertAll(
                () -> assertEquals(student, result),
                () -> verify(service, times(1)).read(student.getId())
        );
    }

    @Test
    @DisplayName("Modify a student")
    public void modifyStudent() {
        // Arrange
        StudentDTO student = StudentFactory.studentPedroModified();

        // Mock
        doNothing().when(service).update(student);

        // Act
        ResponseEntity<?> response = controller.modifyStudent(student);

        // Assert
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> verify(service, times(1)).update(student)
        );
    }

    @Test
    @DisplayName("Delete a student by id")
    public void removeStudent() {
        // Arrange
        StudentDTO student = StudentFactory.studentPedro();

        // Mock
        doNothing().when(service).delete(student.getId());

        // Act
        ResponseEntity<?> response = controller.removeStudent(student.getId());

        // Assert
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> verify(service, times(1)).delete(student.getId())
        );
    }

    @Test
    @DisplayName("Get the list of students")
    public void listStudents() {
        // Arrange
        Set<StudentDTO> students = SchoolFactory.getAllStudents();

        // Mock
        when(service.getAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = controller.listStudents();

        // Assert
        assertAll(
                () -> assertEquals(students, result),
                () -> verify(service, times(1)).getAll()
        );
    }
}
