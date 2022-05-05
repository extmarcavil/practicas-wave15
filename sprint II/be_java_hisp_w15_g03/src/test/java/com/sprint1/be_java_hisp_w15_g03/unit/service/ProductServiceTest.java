package com.sprint1.be_java_hisp_w15_g03.unit.service;

import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import com.sprint1.be_java_hisp_w15_g03.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    IMeliRepository iMeliRepository;

    @InjectMocks
    ProductService productService;


    @Test
    @DisplayName("Tipo de ordenamiento por fecha valido")
    public void getLastPublicationsOk() {

        //arrange
        int id = 1;
        String order = "date_asc";

        Mockito.when(iMeliRepository.getLastPublications(id)).thenReturn(new ArrayList<>());
        Mockito.when(iMeliRepository.hasUser(id)).thenReturn(true);

        //act
        SellerPListDTO result = productService.getLastPublication(id, order);

        //assert
        Assertions.assertNotNull(result);

    }

    @Test
    @DisplayName("Tipo de ordenamiento por fecha invalido")
    public void getLastPublicationsInvalid() {

        //arrange
        int id = 1;
        String order = "date";

        Mockito.when(iMeliRepository.getLastPublications(id)).thenReturn(new ArrayList<>());
        Mockito.when(iMeliRepository.hasUser(id)).thenReturn(true);

        //act & assert
        Assertions.assertThrows(OrderInvalidException.class, () -> productService.getLastPublication(id, order));

    }


}
