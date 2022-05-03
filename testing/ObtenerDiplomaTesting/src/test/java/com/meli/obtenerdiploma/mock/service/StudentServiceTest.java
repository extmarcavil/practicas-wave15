package com.meli.obtenerdiploma.mock.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService service;

    @Test
    @DisplayName("Crear estudiante.")
    void createStudent(){
        // Arrange
        StudentDTO studentMock = StudentFactory.createJuan();

        //MOCK
        //Mockito.when(this.studentDAO.save(studentMock));

        // Act
        this.service.create(studentMock);

        // Assert
        Assertions.assertTrue(this.studentDAO.exists(studentMock));
    }
}
