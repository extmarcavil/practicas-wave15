package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ObtenerDiplomaServiceTest {

    //Ejercicio 2
    //Test Unitarios con Mocks
    //Se requiere crear los tests unitarios necesarios para cubrir el
    // comportamiento de la capa de servicios ObtenerDiplomaService.
    // Tener en cuenta múltiples escenarios y “casos borde” de cada
    // comportamiento.
    //Casos nulos, vacíos, inválidos.
    //Datos de Salida idénticos a datos de Entrada.
    //Cálculo del Promedio.
    //Leyenda del Diploma.
    //Mensaje de Diploma con Honores.

    //Pasos del test Unitario con Mocks
    //Crear el mock IStudentDAO.
    //Inyectarlo en ObtenerDiplomaService.
    //Configurar su comportamiento (setup) con el método when.
    //Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    IObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setUp(){
        studentDAO = new StudentDAO();
        Mockito.when(
                studentDAO.findById(Mockito.any())
        ).thenReturn(
                new StudentDTO()
        );
    }

}
