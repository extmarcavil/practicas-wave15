package com.bootcamp.be_java_hisp_w15_g02.unit.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.UserRepository;
import com.bootcamp.be_java_hisp_w15_g02.service.IUserService;
import com.bootcamp.be_java_hisp_w15_g02.service.UserService;
import com.bootcamp.be_java_hisp_w15_g02.unit.utils.Global;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith({MockitoExtension.class})
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        Global.getListOfUsers();

    }

    @Test
    void verifyAmountOfFollowersIsCorrect() {
        // arrange
        List<User> listUsers = Global.getListOfUsers();
        int countExpected = Global.getUserByIdUtils(5).getFollowerList().size();

        Mockito.when(userRepository.getUserById(5)).thenReturn(Global.getUserByIdUtils(5));
        //act and assert

        GetFollowersCountDTO countResultDTO = userService.getFollowersCount(5);

        Assertions.assertEquals(countExpected, countResultDTO.getFollowersCount());
    }
}
