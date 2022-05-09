package com.bootcamp.be_java_hisp_w15_g08.Units;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g08.service.ProductService;
import com.bootcamp.be_java_hisp_w15_g08.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    ProductService service;

    @Test
    @DisplayName("orden ascendente")
    public void getSellersLastsPosts(){

        //Arrange
        PostListDTO expected = Util.listaDePostOrdenadaYFiltradaAsc();
        User user = Util.user1();
        String order = "date_asc";

        //Mock
        Mockito.when(repository.findUser(user.getUserID())).thenReturn(user);

        //Act
        PostListDTO actual = service.getSellersLastsPosts(user.getUserID(),order);


        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("orden descendente")
    public void getSellersLastsPosts2(){

        //Arrange
        PostListDTO expected = Util.listaDePostOrdenadaYFiltradaDesc();
        User user = Util.user1();
        String order = "date_desc";

        //Mock
        Mockito.when(repository.findUser(user.getUserID())).thenReturn(user);

        //Act
        PostListDTO actual = service.getSellersLastsPosts(user.getUserID(),order);


        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Verificacion de filtadro de fecha")
    public void getSellersLastsPosts3(){

        //Arrange
        PostListDTO expected = Util.listaDePostFiltrada();
        User user = Util.user1();
        String order = null;

        //Mock
        Mockito.when(repository.findUser(user.getUserID())).thenReturn(user);

        //Act
        PostListDTO actual = service.getSellersLastsPosts(user.getUserID(),order);


        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Comprobar si existe el date_asc")
    public void date_asc() {
        //arrange
        String order = "date_asc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        PostListDTO result = service.getSellersLastsPosts(user1.getUserID(), order);

        //asert
        Assert.isInstanceOf(PostListDTO.class, result);
    }

    @Test
    @DisplayName("Comprobar si existe el date_desc")
    public void date_desc() {
        //arrange
        String order = "date_desc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        PostListDTO result = service.getSellersLastsPosts(user1.getUserID(), order);


        //asert

        Assert.isInstanceOf(PostListDTO.class, result);
    }

}
