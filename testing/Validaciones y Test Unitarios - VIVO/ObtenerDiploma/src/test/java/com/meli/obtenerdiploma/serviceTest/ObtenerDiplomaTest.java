package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DecimalFormat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTest {
    @Mock
    IStudentRepository studentRepository;
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Obtener el score correcto")
    void obtenerScoreCorrecto(){
        //arrange
        StudentDTO student = new StudentDTO();
        Long id = 1L;

        //act
        Double score = student.getAverageScore();

        //assert


    }

    @Test
    @DisplayName("Mensaje correcto")
    public void messageSuccessfully() {
        //arrange
        SubjectDTO subDTO1 = new SubjectDTO("Física", 4.0);
        SubjectDTO subDTO2 = new SubjectDTO("Matemática", 6.0);
        String message = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(5.0)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subDTO1, subDTO2));
    }

}
