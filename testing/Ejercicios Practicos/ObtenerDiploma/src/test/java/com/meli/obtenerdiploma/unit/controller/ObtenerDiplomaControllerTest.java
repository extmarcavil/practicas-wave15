package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.unit.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void analizeScores(){

        //arrange
        StudentDTO mock = StudentFactory.getJuan();
        mock.setAverageScore(7.);
        mock.setMessage("ALGO");

        StudentDTO expected= StudentFactory.getJuan();

        Mockito.when(service.analyzeScores(1L)).thenReturn(mock);

        //act
        StudentDTO result=controller.analyzeScores(1L);
        //assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(expected.getStudentName(),result.getStudentName()),
                ()->Assertions.assertEquals(expected.getSubjects(),result.getSubjects()),
                ()->Assertions.assertNotNull(result.getAverageScore()),
                ()->Assertions.assertNotNull(result.getMessage()),
                ()->Mockito.verify(service,Mockito.times(1)).analyzeScores(1L)


        );

    }

}
