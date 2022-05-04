package com.sprint.be_java_hisp_w15_g10.unit.Service;

import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import com.sprint.be_java_hisp_w15_g10.Service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userServiceMock;

    @BeforeEach
     void setup(){

    }

    @Test
    void getUsersWithFollowersCount() {
    }

    @Test
    @DisplayName("Validar que lanza excepción al dejar de seguir a usuario inexitente")
    void unfollowUserUnknownUser() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.unfollowUser(1, 2));
    }

    @Test
    void followUser() {
    }

    @Test
    void getVendorsFollow() {
    }

    @Test
    void getFollowers() {
    }
}