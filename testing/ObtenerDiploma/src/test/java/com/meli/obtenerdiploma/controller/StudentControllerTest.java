package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    @DisplayName("Registrar a un nuevo estudiante")
    public void registerStudentTest() {
        StudentDTO studentMock = StudentFactory.createStudent();

        Mockito.doNothing().when(service).create(studentMock);

        controller.registerStudent(studentMock);

        Mockito.verify(service, Mockito.times(1)).create(studentMock);
    }

    @Test
    @DisplayName("Obtener un estudiante por id")
    public void getStudentTest() {
        StudentDTO studentMock = StudentFactory.createStudent();

        Mockito.when(service.read(1L)).thenReturn(studentMock);

        StudentDTO student = controller.getStudent(1L);

        assertEquals(studentMock, student);
        assertEquals(1L, student.getId());
    }

    @Test
    @DisplayName("Lanza StudentNotFoundException porque el estudiante no existe")
    public void cannotGetStudentTest() {
        Mockito.when(service.read(Mockito.any())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> controller.getStudent(1000L));
    }

    @Test
    @DisplayName("Modificar un estudiante")
    public void modifyStudentTest() {
        StudentDTO studentMock = StudentFactory.getStudentWithAverageScore();

        Mockito.doNothing().when(service).update(studentMock);

        controller.modifyStudent(studentMock);

        Mockito.verify(service, Mockito.times(1)).update(studentMock);
    }

    @Test
    @DisplayName("Eliminar un estudiante")
    public void removeStudentTest() {
        Mockito.doNothing().when(service).delete(1L);

        controller.removeStudent(1L);

        Mockito.verify(service, Mockito.times(1)).delete(1L);
    }

}
