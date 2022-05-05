package com.be.java.hisp.w156.be.java.hisp.w156;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.UserRepositoryImpl;
import com.be.java.hisp.w156.be.java.hisp.w156.service.UserServiceImpl;
import com.be.java.hisp.w156.be.java.hisp.w156.util.UserFollowersFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.be.java.hisp.w156.be.java.hisp.w156.util.UserFollowersFactory.getUser;


@ExtendWith(MockitoExtension.class)
public class UserFollowersTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserServiceImpl service;


    @Test
    @DisplayName("Verificar que la cantidad de seguidores de un determinado usuario sea correcta")
    public void whenGetFollowersCountTest(){

        //arrange
        int idUser = 5;
        int expected = 1;

        Mockito.when(repository.getUser(idUser)).thenReturn(getUser(idUser));

        //act
        ResponseEntity<UserCountFollowersDTO> result = service.getCountFollowers(idUser);

        //asset
        Assertions.assertEquals(expected, result.getBody().getFollowers_count());


    }
}
