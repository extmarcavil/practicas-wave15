package com.sprint1.be_java_hisp_w15_g4.unit;

import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint1.be_java_hisp_w15_g4.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class T0004 {

    @Mock
    private IUserRepository repo;
    @InjectMocks
    private UserService service;

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista")
    void ordenamientoFollowersNameAscOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String ordenamiento="name_asc";

        User user = new User(userId1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        FollowerListDTO listDTO=service.listFollowers(1,ordenamiento);

        //assert

        Assertions.assertAll(
                ()->Assertions.assertEquals(user4.getUser_name(),listDTO.getFollowers().get(0).getUser_name()),
                ()->Assertions.assertEquals(user3.getUser_name(),listDTO.getFollowers().get(1).getUser_name()),
                ()->Assertions.assertEquals(user2.getUser_name(),listDTO.getFollowers().get(2).getUser_name())
        );
    }
}
