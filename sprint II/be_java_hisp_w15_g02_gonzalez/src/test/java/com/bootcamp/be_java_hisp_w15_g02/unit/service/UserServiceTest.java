package com.bootcamp.be_java_hisp_w15_g02.unit.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.UserRepository;
import com.bootcamp.be_java_hisp_w15_g02.service.IUserService;
import com.bootcamp.be_java_hisp_w15_g02.service.UserService;
import com.bootcamp.be_java_hisp_w15_g02.unit.utils.Global;
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

import java.util.ArrayList;
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
    @DisplayName("Verify if the amount of followers is correct.")
    void verifyAmountOfFollowersIsCorrect() {
        //Arrange
        int countExpected = Global.getUserByIdUtils(5).getFollowerList().size();

        Mockito.when(userRepository.getUserById(5)).thenReturn(Global.getUserByIdUtils(5));
        //Act and Assert
        GetFollowersCountDTO countResultDTO = userService.getFollowersCount(5);

        Assertions.assertEquals(countExpected, countResultDTO.getFollowersCount());
    }

    @Test
    @DisplayName("Verify if the User don't have followers.")
    void verifyIfAmountOfFollowersIsEmpty(){
        //Arrange
        //int countExpected = Global.getUserByIdUtils(1).getFollowerList().size();
        Mockito.when(userRepository.getUserById(1)).thenReturn(Global.getUserByIdUtils(1));
        //Act and Assert
        GetFollowersCountDTO countResultDTO = userService.getFollowersCount(1);
        Assertions.assertEquals(0, countResultDTO.getFollowersCount());
    }

    @Test
    @DisplayName("Verify if order type exists.")
    void verifyOrderTypeExists(){
        //Arrange
        List<String> orderExpected = List.of("name_asc","name_desc");
        int userIdExpected = 5;
        Mockito.when(userRepository.getListUser()).thenReturn(Global.getListOfUsers());
        Mockito.when(userRepository.getUserById(5)).thenReturn(Global.getUserByIdUtils(5));
        //Act and Assert
        GetFollowedByUserDTO response = userService.getFollowedByUser(5,orderExpected.get(1));

        Assertions.assertEquals(userIdExpected, response.getUser_id());
    }

    @Test
    @DisplayName("Verify if order type exists with error.")
    void verifyOrderTypeExistsError(){
        //Arrange
        Mockito.when(userRepository.getListUser()).thenReturn(Global.getListOfUsers());
        Mockito.when(userRepository.getUserById(5)).thenReturn(Global.getUserByIdUtils(5));
        //Act and Assert
        Assertions.assertThrows(OrderNotFoundException.class, () -> userService.getFollowedByUser(5,"no_name"));
    }

    @Test
    @DisplayName("Verify if order followers is correct.")
    void verifyCorrectOrderByName(){
        //Arrange
        List<GetFollowersDTO> listExpected = Global.getListSorted("name_desc");
        User user = Global.getUserByIdUtils(5);
        Mockito.when(userRepository.getListUser()).thenReturn(Global.getListOfUsers());
        Mockito.when(userRepository.getUserById(5)).thenReturn(user);

        GetFollowersBySellerDTO response = userService.getFollowersBySeller(5,"name_desc");

        //Act and Assert
        Assertions.assertEquals(listExpected, response.getFollowers());
    }

    @Test
    @DisplayName("Verify if order followers is incorrect.")
    void verifyIncorrectOrderByName(){
        //Arrange
        List<GetFollowersDTO> listExpected = Global.getListSorted("");
        User user = Global.getUserByIdUtils(5);
        Mockito.when(userRepository.getListUser()).thenReturn(Global.getListOfUsers());
        Mockito.when(userRepository.getUserById(5)).thenReturn(user);

        GetFollowersBySellerDTO response = userService.getFollowersBySeller(5,"name_desc");

        //Act and Assert
        Assertions.assertNotEquals(listExpected, response.getFollowers());
    }
}
