package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    CalculateService service;

    @Test
    public void CalculateService(){
        //Arrange
        HouseDTO houseDTO = Util.houseDTO();
        HouseResponseDTO expected = Util.houseResponseDTO();

        //Act
        HouseResponseDTO actual = service.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expected,actual,
                "Las casas no son iguales");
    }
}
