package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.ObtenerDiplomaServiceUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName(" el promedio es 9.0")
    void scoreValid(){
       //arra
        Long studentId = 1L;
        StudentDTO dtoResult = ObtenerDiplomaServiceUtils.studentEmpty();
        dtoResult.setStudentName("Gerson");
        dtoResult.setId(1L);
        dtoResult.setAverageScore(9.0);
        dtoResult.setSubjects(ObtenerDiplomaServiceUtils.listSubjects());
        dtoResult.setMessage("El alumno " + dtoResult.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(dtoResult.getAverageScore())
                + ((dtoResult.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."));
        //mock
        Mockito.when(studentDAO.findById(studentId)).thenReturn(dtoResult);

        //act
        StudentDTO dtoServiceResult = obtenerDiplomaService.analyzeScores(studentId);

        //assert
        Assertions.assertEquals(9.0,dtoServiceResult.getAverageScore());
    }



}
