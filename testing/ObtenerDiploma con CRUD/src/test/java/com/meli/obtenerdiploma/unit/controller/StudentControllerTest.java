package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentFactory;
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
public class StudentControllerTest {

    @Mock
    private IStudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    @DisplayName("Registrar estudiante")
    public void registerStudent() {
        // Arrange
        StudentDTO stu = StudentFactory.createJuan();
        ResponseEntity<?> expected = ResponseEntity.ok(null);

        // Act
        ResponseEntity<?> result = this.controller.registerStudent(stu);

        // Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Obtener estudiante")
    public void getStudent() {
        // Arrange
        StudentDTO stu = StudentFactory.createJuan();

        // MOCK
        Mockito.when(this.service.read(stu.getId())).thenReturn(stu);

        // Act
        StudentDTO result = this.controller.getStudent(stu.getId());

        // Assert
        Assertions.assertEquals(stu, result);
    }

    @Test
    @DisplayName("Modificar estudiante")
    public void modifyStudent() {
        // Arrange
        StudentDTO stu = StudentFactory.createJuan();
        ResponseEntity<?> expected = ResponseEntity.ok(null);

        // Act
        ResponseEntity<?> result = this.controller.modifyStudent(stu);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Eliminar estudiante")
    public void removeStudent() {
        // Arrange
        Long id = 1L;
        ResponseEntity<?> expected = ResponseEntity.ok(null);

        // Act
        ResponseEntity<?> result = this.controller.removeStudent(id);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Obtener todos los estudiantes")
    public void listStudents() {
        // Arrange
        Set<StudentDTO> students = Set.of(StudentFactory.createJuan(), StudentFactory.createPedro());

        // MOCK
        Mockito.when(this.service.getAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = this.controller.listStudents();

        // Assert
        Assertions.assertEquals(students, result);
    }
}
