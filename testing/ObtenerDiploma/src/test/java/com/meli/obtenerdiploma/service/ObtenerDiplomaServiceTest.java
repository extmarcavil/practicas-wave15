package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO dao;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("Calculo correcto del promedio")
    void analyzeScoresTest() {
        StudentDTO studentMock = StudentFactory.createStudent();

        when(dao.findById(1L)).thenReturn(studentMock);

        Double average = (2+8+4)/3D;

        StudentDTO student = service.analyzeScores(1L);

        assertEquals(average, student.getAverageScore());
    }

    @Test
    @DisplayName("Obtener mensaje 'Puedes mejorar'")
    void analyzeScores2Test() {
        StudentDTO studentMock = StudentFactory.createStudent();

        when(dao.findById(1L)).thenReturn(studentMock);

        StudentDTO student = service.analyzeScores(1L);

        assertEquals("El alumno Pedro ha obtenido un promedio de 4.67. Puedes mejorar.",
                student.getMessage());
    }

    @Test
    @DisplayName("Obtener mensaje 'Felicitaciones!'")
    void analyzeScores3Test() {
        StudentDTO studentMock = StudentFactory.createStudent2();

        when(dao.findById(2L)).thenReturn(studentMock);

        StudentDTO student = service.analyzeScores(2L);

        assertEquals("El alumno Juan ha obtenido un promedio de 9.33. Felicitaciones!",
                student.getMessage());
    }

    @Test
    @DisplayName("Datos de salida identicos a los de entrada")
    void analyzeScores4Test() {
        StudentDTO studentMock = StudentFactory.createStudent();

        when(dao.findById(1L)).thenReturn(studentMock);

        StudentDTO student = service.analyzeScores(1L);

        assertEquals(studentMock, student);
    }

    @Test
    @DisplayName("Lanza StudentNotFoundException si se envia un estudiante null")
    void analyzeScores5Test() {
        when(dao.findById(null)).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(null));
    }

    @Test
    @DisplayName("Lanza StudentNotFoundException si no existe el estudiante")
    void analyzeScores6Test() {
        when(dao.findById(Mockito.any())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(1L));
    }


}
