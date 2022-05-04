package com.mercadolibre.calculadorametroscuadrados.unit;


import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class CalculateRestControllerTests {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateController;

    @Test
    void returnsTheCorrectCalculation() {

        Mockito.doNothing().when(repository).save(newStudent);
    }
}
