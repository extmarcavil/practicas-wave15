package com.sprint2.be_java_hisp_w15_g4.unit;

import Utils.TestGenerator;
import com.sprint2.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint2.be_java_hisp_w15_g4.dto.response.FollowingListDTO;
import com.sprint2.be_java_hisp_w15_g4.model.User;
import com.sprint2.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint2.be_java_hisp_w15_g4.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class T0004 {

    @Mock
    private IUserRepository repo;
    @InjectMocks
    private UserService service;

    @Test
    @DisplayName("Verificar que la lista de seguidos se ordene de forma ascendete segun el nombre.")
    void orderFollowersNameAscOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String order="name_asc";

        User user = TestGenerator.userWithFollowers();
        Mockito.when(repo.findUser(1)).thenReturn(user);


        //act
        FollowerListDTO listDTO=service.listFollowers(1,order);

        //assert

        Assertions.assertAll(
                ()->Assertions.assertEquals("aombre2",listDTO.getFollowers().get(0).getUser_name()),
                ()->Assertions.assertEquals("lombre2",listDTO.getFollowers().get(1).getUser_name()),
                ()->Assertions.assertEquals("nombre2",listDTO.getFollowers().get(2).getUser_name())
        );
    }

    @Test
    @DisplayName("Verificar que la lista de seguidores se ordene de forma ascendete segun el nombre.")
    void orderFollowingNameAscOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String order="name_asc";

        User user = TestGenerator.userWithFollowings();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        FollowingListDTO listDTO=service.listFollowing(1,order);

        //assert

        Assertions.assertAll(
                ()->Assertions.assertEquals("aombre2",listDTO.getFollowed().get(0).getUser_name()),
                ()->Assertions.assertEquals("lombre2",listDTO.getFollowed().get(1).getUser_name()),
                ()->Assertions.assertEquals("nombre2",listDTO.getFollowed().get(2).getUser_name())
        );
    }

    @Test
    @DisplayName("Verificar que la lista de seguidos se ordene de forma descendente segun el nombre.")
    void orderFollowersNamedescOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String order="name_desc";

        User user = TestGenerator.userWithFollowers();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        FollowerListDTO listDTO=service.listFollowers(1,order);

        //assert

        Assertions.assertAll(
                ()->Assertions.assertEquals("nombre2",listDTO.getFollowers().get(0).getUser_name()),
                ()->Assertions.assertEquals("lombre2",listDTO.getFollowers().get(1).getUser_name()),
                ()->Assertions.assertEquals("aombre2",listDTO.getFollowers().get(2).getUser_name())
        );
    }

    @Test
    @DisplayName("Verificar que la lista de seguidores se ordene de forma descendete segun el nombre.")
    void orderFollowingNameDescOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String order="name_desc";

        User user = TestGenerator.userWithFollowings();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        FollowingListDTO listDTO=service.listFollowing(1,order);

        //assert

        Assertions.assertAll(
                ()->Assertions.assertEquals("nombre2",listDTO.getFollowed().get(0).getUser_name()),
                ()->Assertions.assertEquals("lombre2",listDTO.getFollowed().get(1).getUser_name()),
                ()->Assertions.assertEquals("aombre2",listDTO.getFollowed().get(2).getUser_name())
        );
    }
}
