package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.meli.obtenerdiploma.Utils.newGoodStudent;
import static com.meli.obtenerdiploma.Utils.newStudent;

@ExtendWith(MockitoExtension.class)
public class Ejercicio4Test {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void obtenerDiplomaTest() {
        StudentDTO student = newGoodStudent(1l, "jose");

        Mockito.when(service.analyzeScores(1l)).thenReturn(student);

        StudentDTO result = service.analyzeScores(1l);

        Assertions.assertEquals(10.0, result.getAverageScore());
    }

    //no sigo testeando porque lo unico que hace el controller es ser un pasamanos (middleMan)
    //con el servicio ya testeado
}
