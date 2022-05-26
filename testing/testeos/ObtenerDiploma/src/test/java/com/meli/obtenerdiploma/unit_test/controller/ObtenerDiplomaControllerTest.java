package com.meli.obtenerdiploma.unit_test.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentDTOFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresSuccess() {
        StudentDTO student1= StudentDTOFactory.createStudent();

        // MOCK
        when(obtenerDiplomaController.analyzeScores(anyLong()))
                .thenReturn(student1);
        //Mockito.when(studentDAO.findById(Mockito.anyLong())).thenReturn(student1);
        /*Mockito.when(service.analyzeScores(Mockito.anyLong()))
                .thenReturn(student1);*/
        StudentDTO result=obtenerDiplomaController.analyzeScores(student1.getId());
        //Mockito.verify(service,Mockito.times(1))
                //.analyzeScores(student1.getId());

        assertEquals(student1,result);
        //Assertions.assertTrue(result.getMessage()==1L);

    }
}
