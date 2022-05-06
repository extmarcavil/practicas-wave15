package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.MakeStudentsDTO;
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
    public void analyzeScores(){
        //Arrange
        StudentDTO expexted = MakeStudentsDTO.StudentDTOId1WhitScore();
        Long studentId = 1L;

        //Mock
        Mockito.when(service.analyzeScores(Mockito.anyLong())).thenReturn(expexted);
        //Act
        StudentDTO actual = controller.analyzeScores(studentId);

        //Assert
        Assertions.assertEquals(expexted,actual);

    }
}
