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
        Mockito.verify(studentDAO).save(s);
    }

    @Test
    @DisplayName("Read llame a findById")
    public void test_read() {
        // Given
        Long id = 5L;

        // When
        studentService.read(id);

        // Then
        Mockito.verify(studentDAO).findById(id);
    }

    @Test
    @DisplayName("Read encuentre el objeto correcto")
    public void test_readFindCorrectObject() {
        // Given
        Long id = 50L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        s.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(s);

        // When
        StudentDTO result = studentService.read(id);

        // Then
        Assertions.assertEquals(s, result);
    }

    @Test
    @DisplayName("Update llame a save")
    public void test_update() {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();

        // When
        studentService.update(s);

        // Then
        Mockito.verify(studentDAO).save(s);
    }

    @Test
    @DisplayName("Delete llame a delete")
    public void test_delete() {
        // Given
        Long id = 5L;

        // When
        studentService.delete(id);

        // Then
        Mockito.verify(studentDAO).delete(id);
    }

    @Test
    @DisplayName("Find all retorne el set del repo")
    public void test_findAll() {
        // Given
        Long id = 50L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        s.setId(id);
        Set<StudentDTO> students = Set.of(s);
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        // When
        Set<StudentDTO> result = studentService.getAll();

        // Then
        Assertions.assertEquals(students, result);
    }
}
