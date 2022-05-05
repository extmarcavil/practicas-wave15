package com.bootcamp.be_java_hisp_w15_g08.Units;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g08.service.UserService;
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
public class UserServiceTest {
    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService service;


    @Test
    @DisplayName("Comprobar si existe el name_asc")
    public void name_asc(){
        //arrange
        String order = "name_asc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        FollowersListDTO result = service.getFollowedList(user1.getUserID(),order);

        //asert
        //Assertions.assertDoesNotThrow();
        //Assertions.assertInstanceOf(FollowersListDTO.class, result);
        Assert.isInstanceOf(FollowersListDTO.class, result);
    }


    @Test
    @DisplayName("Comprobar si existe el name_desc")
    public void name_desc(){
        //arrange
        String order ="name_desc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        FollowersListDTO result = service.getFollowedList(1234,order);

        //asert
        Assert.isInstanceOf(FollowersListDTO.class, result);
    }

    @Test
    @DisplayName("Comprobar cuando el parametro es incorrecto")
    public void name_error(){
        //arrange
        String order ="Not_Foud_Mister_Json";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act y asert
       Assertions.assertThrows(IllegalArgumentException.class
               ,()->service.getFollowedList(1234,order));
    }

    @Test
    @DisplayName("Comprobar cuando el parametro es incorrecto")
    public void name_error2(){
        //arrange
        String order ="Not_Foud_Mister_Json";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act y asert
        Assertions.assertThrows(IllegalArgumentException.class
                ,()->service.getFollowersList(1234,order));
    }

    @Test
    @DisplayName("Comprobar si es correcto el orden ascendente")
    public void getFollowersListAsc(){
        //arrange
        FollowersListDTO expected = Util.asc_List();
        String order = "name_asc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        FollowersListDTO actual = service.getFollowersList(user1.getUserID(),order);

        //asert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Comprobar si es correcto el orden descendente")
    public void getFollowersListDesc(){
        //arrange
        FollowersListDTO expected = Util.desc_List();
        String order = "name_desc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        FollowersListDTO actual = service.getFollowersList(user1.getUserID(),order);

        //asert
        Assertions.assertEquals(expected,actual);
    }


    @Test
    @DisplayName("Comprobar si la cantidad de followers son correctos")
    public void getFollowersCount(){
        //arrange
        User user2 = Util.user2();

        //Mock
        Mockito.when(repository.findUser(user2.getUserID())).thenReturn(user2);

        //act
        FollowersCountDTO followersCountDTO = service.countFollers(user2.getUserID());


        //asert
        Assertions.assertEquals(followersCountDTO.getFollowers_count(),user2.getFollowers().size());
    }
}
