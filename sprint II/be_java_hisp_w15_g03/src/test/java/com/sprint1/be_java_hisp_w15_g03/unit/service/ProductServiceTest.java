package com.sprint1.be_java_hisp_w15_g03.unit.service;

import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PublicationRespDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    IMeliRepository iMeliRepository;

    @InjectMocks
    ProductService productService;


    //T-0005
    @Test
    @DisplayName("Tipo de ordenamiento por fecha valido")
    public void getLastPublicationsOk(){

        //arrange
        Integer id= 1;
        String order = "date_asc";

        Mockito.when(iMeliRepository.getLastPublications(id)).thenReturn(new ArrayList<>());
        Mockito.when(iMeliRepository.hasUser(id)).thenReturn(true);

        //act
        SellerPListDTO result = productService.getLastPublication(id, order);

        //assert
        Assertions.assertNotNull(result);

    }

    //T-0005
    @Test
    @DisplayName("Tipo de ordenamiento por fecha invalido")
    public void getLastPublicationsInvalid(){

        //arrange
        Integer id= 1;
        String order = "date";

        Mockito.when(iMeliRepository.getLastPublications(id)).thenReturn(new ArrayList<>());
        Mockito.when(iMeliRepository.hasUser(id)).thenReturn(true);
        
        //act & assert
        Assertions.assertThrows(OrderInvalidException.class, () -> productService.getLastPublication(id, order));

    }

    //T-0005
    @Test
    @DisplayName("Tipo de ordenamiento por fecha null")
    public void getLastPublicationsOrderNullOk(){

        //arrange
        Integer id= 1;
        String order = null;

        Mockito.when(iMeliRepository.getLastPublications(id)).thenReturn(new ArrayList<>());
        Mockito.when(iMeliRepository.hasUser(id)).thenReturn(true);

        //act
        SellerPListDTO result = productService.getLastPublication(id, order);

        //assert
        Assertions.assertNotNull(result);

    }

    //T-0006
    @Test
    @DisplayName("Tipo de ordenamiento verificar ordenamiento ascendente correcto")
    public void getLastPublicationsOrderAscOk(){

        //arrange
        Integer id= 1;
        String order = "date_asc";
        Product product = new Product(1, "Mesa", null, null, null, null);
        Publication publication1 = new Publication(1, LocalDate.parse("2022-05-05"), Category.MESA, 300.0, product, null, null);
        Publication publication2 = new Publication(2, LocalDate.parse("2022-05-03"), Category.MESA, 300.0, product, null, null);
        List<Publication> publications = Arrays.asList(publication1, publication2);

        ProductDTO productDTO = new ProductDTO(1, "Mesa", null, null, null, null);
        PublicationRespDTO publicationDTO1 = new PublicationRespDTO(1, LocalDate.parse("2022-05-05"), 2, 300.0, productDTO);
        PublicationRespDTO publicationDTO2 = new PublicationRespDTO(2, LocalDate.parse("2022-05-03"), 2, 300.0, productDTO);
        List<PublicationRespDTO> publicationsInOrder = Arrays.asList(publicationDTO2, publicationDTO1);


        Mockito.when(iMeliRepository.getLastPublications(id)).thenReturn(publications);
        Mockito.when(iMeliRepository.hasUser(id)).thenReturn(true);

        //act
        SellerPListDTO result = productService.getLastPublication(id, order);

        //assert
        Assertions.assertEquals(publicationsInOrder.get(0).getDate(), result.getPosts().get(0).getDate());
        Assertions.assertEquals(publicationsInOrder.get(1).getDate(), result.getPosts().get(1).getDate());

    }

    //T-0006
    @Test
    @DisplayName("Tipo de ordenamiento verificar ordenamiento descendente correcto")
    public void getLastPublicationsOrderDescOk(){

        //arrange
        Integer id= 1;
        String order = "date_desc";
        Product product = new Product(1, "Mesa", null, null, null, null);
        Publication publication1 = new Publication(1, LocalDate.parse("2022-05-05"), Category.MESA, 300.0, product, null, null);
        Publication publication2 = new Publication(2, LocalDate.parse("2022-05-03"), Category.MESA, 300.0, product, null, null);
        List<Publication> publications = Arrays.asList(publication2, publication1);

        ProductDTO productDTO = new ProductDTO(1, "Mesa", null, null, null, null);
        PublicationRespDTO publicationDTO1 = new PublicationRespDTO(1, LocalDate.parse("2022-05-05"), 2, 300.0, productDTO);
        PublicationRespDTO publicationDTO2 = new PublicationRespDTO(2, LocalDate.parse("2022-05-03"), 2, 300.0, productDTO);
        List<PublicationRespDTO> publicationsInOrder = Arrays.asList(publicationDTO1, publicationDTO2);


        Mockito.when(iMeliRepository.getLastPublications(id)).thenReturn(publications);
        Mockito.when(iMeliRepository.hasUser(id)).thenReturn(true);

        //act
        SellerPListDTO result = productService.getLastPublication(id, order);

        //assert
        Assertions.assertEquals(publicationsInOrder.get(0).getDate(), result.getPosts().get(0).getDate());
        Assertions.assertEquals(publicationsInOrder.get(1).getDate(), result.getPosts().get(1).getDate());

    }



}
