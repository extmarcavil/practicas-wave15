package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.MakeStudentsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    @DisplayName("Comparando dos objetos iguales")
    public void analyzeScores() {
        //arrange
        StudentDTO expected = MakeStudentsDTO.StudentDTOId1WhitScore();

        //act
        Mockito.when(studentDAO.findById(1L)).thenReturn(MakeStudentsDTO.StudentDTOId1());
        StudentDTO actual = service.analyzeScores(1L);

        //assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Comparando dos promedio iguales")
    public void analyzeScores2() {
        //arrange
        StudentDTO expected = MakeStudentsDTO.StudentDTOId1WhitScore();

        //act
        Mockito.when(studentDAO.findById(1L)).thenReturn(MakeStudentsDTO.StudentDTOId1());
        StudentDTO actual = service.analyzeScores(1L);

        //assert
        Assertions.assertEquals(expected.getAverageScore(),actual.getAverageScore());
    }

    @Test
    @DisplayName("Comparando dos mensajes iguales")
    public void analyzeScores3() {
        //arrange
        StudentDTO expected = MakeStudentsDTO.StudentDTOId1WhitScore();

        //act
        Mockito.when(studentDAO.findById(1L)).thenReturn(MakeStudentsDTO.StudentDTOId1());
        StudentDTO actual = service.analyzeScores(1L);

        //assert
        Assertions.assertEquals(expected.getMessage(),actual.getMessage());
    }




}
