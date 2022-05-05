package com.sprint.be_java_hisp_w15_g10.unit.Controller;

import com.sprint.be_java_hisp_w15_g10.Controller.UserController;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;

    @Test
    void getUserWitFollowersCount() {
        // arrange
        UserWithFollowersCountDTO userWithFollowersCountDTO = new UserWithFollowersCountDTO(1,"Luis", 6);
        Mockito.when(userService.getUsersWithFollowersCount(Mockito.anyInt())).thenReturn(userWithFollowersCountDTO);
        // act
        ResponseEntity<UserWithFollowersCountDTO> response = userController.getUserWitFollowersCount(1);
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(userService, Mockito.times(1)).getUsersWithFollowersCount(Mockito.anyInt());},
                ()->{Assertions.assertEquals(userWithFollowersCountDTO, response.getBody());}
        );
    }

    @Test
    void unfollowUser() {
        // arrange
        UnfollowUserDTO unfollowUserDTO =new UnfollowUserDTO("Se ha dejado de seguir al usuario: Luis");
        Mockito.when(userService.unfollowUser(Mockito.anyInt(), Mockito.anyInt())).thenReturn(unfollowUserDTO);
        // act
        ResponseEntity<UnfollowUserDTO> response = userController.unfollowUser(1, 2);
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(userService, Mockito.times(1)).unfollowUser(Mockito.anyInt(), Mockito.anyInt());},
                ()->{Assertions.assertEquals(unfollowUserDTO, response.getBody());}
        );
    }

    @Test
    void getUserFollowers() {
        // arrange
        FollowersDTO followersDTO = new FollowersDTO();
        Mockito.when(userService.getFollowers(Mockito.anyInt(), Mockito.anyString())).thenReturn(followersDTO);
        // act
        ResponseEntity<FollowersDTO> response = userController.getUserFollowers(1, "name_asc");
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(userService, Mockito.times(1)).getFollowers(Mockito.anyInt(), Mockito.anyString());},
                ()->{Assertions.assertEquals(followersDTO, response.getBody());}
        );
    }

    @Test
    void followUser() {
        // arrange
        FollowUserDTO followUserDTO = new FollowUserDTO();
        Mockito.when(userService.followUser(Mockito.anyInt(), Mockito.anyInt())).thenReturn(followUserDTO);
        // act
        ResponseEntity<FollowUserDTO> response = userController.followUser(1, 2);
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(userService, Mockito.times(1)).followUser(Mockito.anyInt(), Mockito.anyInt());},
                ()->{Assertions.assertEquals(followUserDTO, response.getBody());}
        );
    }

    @Test
    void getVendorsFollow() {
        // arrange
        VendedorsFollowedDTO vendedorsFollowedDTO = new VendedorsFollowedDTO();
        Mockito.when(userService.getVendorsFollow(Mockito.anyInt(), Mockito.anyString())).thenReturn(vendedorsFollowedDTO);
        // act
        ResponseEntity<VendedorsFollowedDTO> response = userController.getVendorsFollow(1, "name_asc");
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(userService, Mockito.times(1)).getVendorsFollow(Mockito.anyInt(), Mockito.anyString());},
                ()->{Assertions.assertEquals(vendedorsFollowedDTO, response.getBody());}
        );
    }
}