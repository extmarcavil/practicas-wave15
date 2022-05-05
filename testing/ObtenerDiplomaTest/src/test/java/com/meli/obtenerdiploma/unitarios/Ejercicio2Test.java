package com.meli.obtenerdiploma.unitarios;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.meli.obtenerdiploma.utilidades.Utils.*;

@ExtendWith(MockitoExtension.class)
public class Ejercicio2Test {
    @Mock
    IStudentDAO sdao;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    void analyzeScoresAverageTest() {
        StudentDTO student = newStudent(1l, "jose");

        Mockito.when(sdao.findById(1l)).thenReturn(student);

        StudentDTO result = service.analyzeScores(1l);

        Assertions.assertEquals(8.0, result.getAverageScore());
        System.out.println(result.getMessage());
    }

    @Test
    void analyzeScoresGoodMessageTest() {
        StudentDTO student = newGoodStudent(1l, "jose");

        Mockito.when(sdao.findById(1l)).thenReturn(student);

        StudentDTO result = service.analyzeScores(1l);

        Assertions.assertEquals(student.getMessage(), result.getMessage());
    }

    @Test
    void analyzeScoresbadMessageTest() {
        StudentDTO student = newBadStudent(1l, "jose");

        Mockito.when(sdao.findById(1l)).thenReturn(student);

        StudentDTO result = service.analyzeScores(1l);

        Assertions.assertEquals(student.getMessage(), result.getMessage());
    }
}
