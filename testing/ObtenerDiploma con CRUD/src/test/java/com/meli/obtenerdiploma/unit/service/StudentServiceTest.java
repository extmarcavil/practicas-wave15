package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    @DisplayName("Crear estudiante")
    void createStudent(){
        // Arrange
        StudentDTO studentMock = StudentFactory.createJuan();

        // Act
        this.service.create(studentMock);

        // Assert
        Mockito.verify(studentDAO).save(studentMock);
    }

    @Test
    @DisplayName("Busco el estudiante - Id correcto")
    public void readStudent() {
        // Arrange
        Long id = 1L;
        StudentDTO studentMock = StudentFactory.createJuan();

        //MOCK
        Mockito.when(this.studentDAO.findById(id)).thenReturn(studentMock);

        // Act
        StudentDTO result = this.service.read(id);

        // Assert
        Assertions.assertEquals(studentMock, result);
    }

    @Test
    @DisplayName("Actualizo el estudiante")
    public void updateStudent() {
        // Arrange
        StudentDTO studentMock = StudentFactory.createJuan();

        // Act
        this.service.update(studentMock);

        // Assert
        Mockito.verify(this.studentDAO).save(studentMock);
    }

    @Test
    @DisplayName("Eliminar estudiante")
    public void deleteStudent() {
        // Arrange
        Long id = 1L;

        // Act
        this.service.delete(id);

        // Assert
        Mockito.verify(this.studentDAO).delete(id);
    }

    @Test
    @DisplayName("Obtener todos los estudiantes")
    public void findAllStudents() {
        // Arrange
        StudentDTO studentMock = StudentFactory.createJuan();
        Set<StudentDTO> students = Set.of(studentMock);

        // MOCK
        Mockito.when(this.studentRepository.findAll()).thenReturn(students);

        // Act
        Set<StudentDTO> result = this.service.getAll();

        // Assert
        Assertions.assertEquals(students, result);
    }

}
