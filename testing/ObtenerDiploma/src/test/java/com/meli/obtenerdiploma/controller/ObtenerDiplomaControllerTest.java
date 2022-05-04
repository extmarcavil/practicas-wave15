package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("Obtencion correcta del estudiante")
    void analyzeScoresTest() {
        StudentDTO studentMock = StudentFactory.getStudentWithAverageScore();

        Mockito.when(service.analyzeScores(1L)).thenReturn(studentMock);

        StudentDTO student = controller.analyzeScores(1L);

        assertEquals(studentMock, student);
        assertNotNull(student.getMessage());
        assertNotNull(student.getMessage());
    }

    @Test
    @DisplayName("Lanza StudentNotFoundException cuando el estudiante no existe")
    void analyzeScores2Test() {
        Mockito.when(service.analyzeScores(Mockito.any())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> controller.analyzeScores(10000L));
    }

}
