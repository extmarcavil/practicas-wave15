package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;


    @Test
    @DisplayName("Obtener promedio estudiante - Id OK")
    void analyzeScoresIdOK(){
        // Arrange
        Long id = 1L;
        Double score = 7.333333333333333;
        StudentDTO studentMock = StudentFactory.createJuan();

        // MOCK
        Mockito.when(this.studentDAO.findById(id)).thenReturn(studentMock);

        // Act
        StudentDTO result = service.analyzeScores(id);

        // Assert
        Assertions.assertEquals(score, result.getAverageScore());
    }

/*
    No es responsabilidad del metodo validar la existencia del id.
    @Test
    @DisplayName("Obtener promedio estudiante - No existe el id y lanza excepción")
    void analyzeScoresNonExistingId(){
        // Arrange
        Long id = 10L;

        // MOCK
        Mockito.when(this.studentDAO.findById(id)).thenThrow(StudentNotFoundException.class);

        // Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> this.service.analyzeScores(id));
    }
*/

    @Test
    @DisplayName("Obtener promedio estudiante - Puede mejorar")
    void analyzeScoresLessThan10(){
        // Arrange
        Long id = 1L;
        String message = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
        StudentDTO studentMock = StudentFactory.createJuan();

        // MOCK
        Mockito.when(this.studentDAO.findById(id)).thenReturn(studentMock);

        // Act
        StudentDTO result = service.analyzeScores(id);

        // Assert
        Assertions.assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Obtener promedio estudiante - Puedes mejorar")
    void analyzeScoresMoreThan9(){
        // Arrange
        Long id = 2L;
        String message = "El alumno Pedro ha obtenido un promedio de 10. Felicitaciones!";
        StudentDTO studentMock = StudentFactory.createPedro();

        // MOCK
        Mockito.when(this.studentDAO.findById(id)).thenReturn(studentMock);

        // Act
        StudentDTO result = service.analyzeScores(id);

        // Assert
        Assertions.assertEquals(message, result.getMessage());
    }
}
