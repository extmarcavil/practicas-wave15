package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestStudentService {

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Crear llame a save")
    public void test_create() {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();

        // When
        studentService.create(s);

        // Then
        verify(studentDAO).save(s);
    }

    @Test
    @DisplayName("Read llame a findById")
    public void test_read() {
        // Given
        Long id = 5L;

        // When
        studentService.read(id);

        // Then
        verify(studentDAO).findById(id);
    }

    @Test
    @DisplayName("Read encuentre el objeto correcto")
    public void test_readFindCorrectObject() {
        // Arrange
        Long id = 50L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        s.setId(id);
        StudentDTO s1 = StudentFactory.createStraightAStudent();
        s1.setId(id);
        when(studentDAO.findById(id)).thenReturn(s);

        // Act
        StudentDTO result = studentService.read(id);

        // Assert
        assertEquals(s1, result);
    }

    @Test
    @DisplayName("Update llame a save")
    public void test_update() {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();

        // When
        studentService.update(s);

        // Then
        verify(studentDAO).save(s);
    }

    @Test
    @DisplayName("Delete llame a delete")
    public void test_delete() {
        // Given
        Long id = 5L;

        // When
        studentService.delete(id);

        // Then
        verify(studentDAO).delete(id);
    }

    @Test
    @DisplayName("Find all retorne el set del repo")
    public void test_findAll() {
        // Given
        Long id = 50L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        s.setId(id);
        Set<StudentDTO> students = Set.of(s);
        when(studentRepository.findAll()).thenReturn(students);

        // When
        Set<StudentDTO> result = studentService.getAll();

        // Then
        assertEquals(students, result);
    }
}
