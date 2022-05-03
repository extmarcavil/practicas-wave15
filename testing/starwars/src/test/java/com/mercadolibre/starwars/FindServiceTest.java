package com.mercadolibre.starwars;

import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository repo;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Busqueda con parametro correcto retorna lo esperado")
    void findTest() {
        //arrange
        //Mocks
        //act
        //assert

    }
}
