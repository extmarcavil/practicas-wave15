package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.unit.utils.StudentFactory;
import org.junit.jupiter.api.*;
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
    ObtenerDiplomaService service = new ObtenerDiplomaService();

    @BeforeEach
    void setUp(){

        ///*
        StudentDTO juanMock= StudentFactory.getJuan();
        Mockito.when(studentDAO.findById(1L)).thenReturn(juanMock);
        //*/
        ///*
        StudentDTO pedroMock= StudentFactory.getPedro();
        Mockito.when(studentDAO.findById(2L)).thenReturn(pedroMock);
         //*/
    }

    @Test
    @DisplayName("Se comprueba que los calculos de entrada no cambien.")
    void comprobarDatosIO(){
        //arr
        Long studenId=1L;

        //act
        StudentDTO result=  service.analyzeScores(studenId);

        StudentDTO result2= StudentFactory.getJuan();

        //assert
        Assertions.assertAll(
                ()->Assertions.assertEquals(result2.getId(),result.getId()),
                ()->Assertions.assertEquals(result2.getStudentName(),result.getStudentName()),
                ()->Assertions.assertEquals(result2.getSubjects(),result.getSubjects())
                );
    }

    @Test
    @DisplayName("Se comprueba el cambio en message y averageScore")
    void comprobarDatosIO2(){
        //arr
        Long studenId=2L;

        //act
        StudentDTO result= service.analyzeScores(studenId);

        //assert
        Assertions.assertNotNull(result.getMessage());
        Assertions.assertNotNull(result.getAverageScore());

    }


    @Test
    @DisplayName("Se comprueba el correcto calculo del promedio final")
    void comprobarCalculo(){
        //arr
        Double scoreExpected= 7.;
        Long studenId=1L;

        //act
        StudentDTO result=service.analyzeScores(studenId);

        //assert
        Assertions.assertEquals(scoreExpected,result.getAverageScore());
    }

    @Test
    @DisplayName("Se comprueba la correcta obtencion del msj Puedes mejorar")
    void comprobarMessagePuedesMejorar(){
        //arr
        Long studenId=1L;

        //act
        StudentDTO result=service.analyzeScores(studenId);

        //assert
        Assertions.assertTrue(result.getMessage().contains("Puedes mejorar"));
    }


    @Test
    @DisplayName("Se comprueba la correcta obtencion del msj Felicidades")
    void comprobarMessageFelicitaciones(){
        //arr
        Long studenId=2L;

        //act
        StudentDTO result=service.analyzeScores(studenId);

        //assert
        Assertions.assertTrue(result.getMessage().contains("Felicitaciones!"));
    }


}
