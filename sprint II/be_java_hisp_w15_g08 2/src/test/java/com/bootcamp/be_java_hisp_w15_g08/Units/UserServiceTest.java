package com.bootcamp.be_java_hisp_w15_g08.Units;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.exception.FollowException;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g08.repository.UserRepository;
import com.bootcamp.be_java_hisp_w15_g08.service.UserService;
import com.bootcamp.be_java_hisp_w15_g08.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;
import java.util.ArrayList;

import static org.mockito.Mockito.when;


public class UserServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService service;

    @BeforeEach
    void setup(){
        repository = new UserRepository();
    }


    @Test
    @DisplayName("Comprobar si existe el name_asc")
    public void name_asc(){
        //arrange
        String order = "name_asc";
        User user1 = Util.user1();

        //Mock
        when(repository.findUser(user1.getUserID())).thenReturn(user1);

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
        when(repository.findUser(user1.getUserID())).thenReturn(user1);

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
        when(repository.findUser(user1.getUserID())).thenReturn(user1);

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
        when(repository.findUser(user1.getUserID())).thenReturn(user1);

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
        when(repository.findUser(user1.getUserID())).thenReturn(user1);

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
        when(repository.findUser(user1.getUserID())).thenReturn(user1);

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
        when(repository.findUser(user2.getUserID())).thenReturn(user2);

        //act
        FollowersCountDTO followersCountDTO = service.countFollers(user2.getUserID());


        //asert
        Assertions.assertEquals(followersCountDTO.getFollowers_count(),user2.getFollowers().size());
    }

    @Test
    void VerifyThatUserToFollowExistAndReturn() {

        User userToFollow = new User();
        userToFollow.setUserID(1);
        userToFollow.setName("Marcelo");

        User userFollowed = new User();
        userFollowed.setUserID(2);
        userFollowed.setName("Seguido");

        userFollowed.setFollowers(new ArrayList<>());
        when(repository.findUser(userFollowed.getUserID())).thenReturn(userFollowed);
        when(repository.findUser(userToFollow.getUserID())).thenReturn(userToFollow);

        service.followUser(2,1);


        Mockito.verify(repository,Mockito.atLeastOnce()).findUser(userFollowed.getUserID());
        Mockito.verify(repository,Mockito.atLeastOnce()).findUser(userToFollow.getUserID());


    }


    @Test
    void VerifyThatUserToUnfollowExist() {

        User follower = new User();
        follower.setUserID(1);
        follower.setName("Seguidor");

        User followed = new User();
        followed.setUserID(2);
        followed.setName("Seguido");

        followed.setFollowers(new ArrayList<>());
        followed.addFollower(follower);

        when(repository.findUser(followed.getUserID())).thenReturn(followed);
        when(repository.findUser(follower.getUserID())).thenReturn(follower);

        service.unFollowUser(2,1);


        Mockito.verify(repository,Mockito.atLeastOnce()).findUser(followed.getUserID());
        Mockito.verify(repository,Mockito.atLeastOnce()).findUser(follower.getUserID());



    }



    @Test
    void VerifyThatUserToUnfollowDoesntExistAndThrowsExcept(){

        User follower = new User();
        follower.setUserID(1);
        follower.setName("Seguidor");

        User followed = new User();
        followed.setUserID(2);
        followed.setName("Seguido");

        followed.setFollowers(new ArrayList<>());


        when(repository.findUser(followed.getUserID())).thenReturn(followed);
        when(repository.findUser(follower.getUserID())).thenReturn(follower);

       // Assertions.assertThrows(FollowException.class,()-> service.unFollowUser(2,1));

    }
    
}
