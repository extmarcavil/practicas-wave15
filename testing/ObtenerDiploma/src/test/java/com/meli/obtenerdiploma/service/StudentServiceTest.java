package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    StudentService service;

    @Mock
    IStudentDAO dao;
    @Mock
    IStudentRepository repository;

    @Test
    @DisplayName("Crear un estudiante")
    void createTest() {
        StudentDTO studentMock = StudentFactory.createStudent();

        Mockito.doNothing().when(dao).save(studentMock);

        service.create(studentMock);

        Mockito.verify(dao, Mockito.times(1)).save(studentMock);
    }

    @Test
    @DisplayName("Obtener un estudiante")
    void readTest() {
        StudentDTO studentMock = StudentFactory.createStudent();

        Mockito.when(dao.findById(1L)).thenReturn(studentMock);

        StudentDTO student = service.read(1L);

        assertEquals(studentMock, student);
    }

    @Test
    @DisplayName("Lanza StudentNotFoundException si no existe el estudiante")
    void cannotReadTest() {
        Mockito.when(dao.findById(Mockito.any())).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class, () -> service.read(1000L));
    }

    @Test
    @DisplayName("Actualiza un estudiante")
    void updateTest() {
        StudentDTO studentMock = StudentFactory.createStudent();

        Mockito.doNothing().when(dao).save(studentMock);

        service.update(studentMock);

        Mockito.verify(dao, Mockito.times(1)).save(studentMock);
    }

    @Test
    @DisplayName("Elimina un estudiante")
    void deleteTest() {
        Mockito.when(dao.delete(1L)).thenReturn(true);

        service.delete(1L);

        Mockito.verify(dao, Mockito.times(1)).delete(1L);
    }


    @Test
    @DisplayName("Obtener todos los estudiantes")
    void getAllStudentsTest() {
        Set<StudentDTO> studentsMock = StudentFactory.getAllStudents();

        Mockito.when(repository.findAll()).thenReturn(studentsMock);

        Set<StudentDTO> students = service.getAll();

        assertFalse(students.isEmpty());
        assertEquals(studentsMock, students);
    }

}
