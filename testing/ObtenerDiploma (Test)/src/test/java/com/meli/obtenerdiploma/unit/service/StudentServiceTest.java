package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO repository;

    @InjectMocks
    StudentService service;

    @Test
    @DisplayName("Create student")
    public void createStudent() {
        // Arrange
        StudentDTO newStudent = StudentFactory.studentMaria();

        // Mock
        doNothing().when(repository).save(newStudent);

        // Act
        service.create(newStudent);

        // Assert
        verify(repository, times(1)).save(newStudent);
    }
}
