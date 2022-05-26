package com.meli.obtenerdiploma.unit_test.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentDTOFactory;
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
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Probamos que el calculo de promedio sea correcto")
    public void testAverage(){
        Double resultProm=9D;
        StudentDTO student1=StudentDTOFactory.createStudent();

        // MOCK
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenReturn(student1);

        StudentDTO studentResult=obtenerDiplomaService.analyzeScores(student1.getId());

        Assertions.assertEquals(resultProm,studentResult.getAverageScore());
    }

    @Test
    @DisplayName("Probamos que si se lanza el mensaje del promedio")
    public void testMessage(){
        StudentDTO student1=StudentDTOFactory.createStudent();
        String resultadoEsperado="El alumno "+student1.getStudentName()+" ha obtenido un promedio de 9. Puedes mejorar.";

        // MOCK
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenReturn(student1);

        StudentDTO studentResult=obtenerDiplomaService.analyzeScores(student1.getId());

        Assertions.assertEquals(resultadoEsperado,studentResult.getMessage());
    }
}
