package com.social.media.sprgbt.unit.facade;

import com.social.media.sprgbt.dto.FollowerDto;
import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.exception.OrderNotExistingException;
import com.social.media.sprgbt.facade.impl.ApplicationUserFacadeImpl;
import com.social.media.sprgbt.service.IFollowerService;
import com.social.media.sprgbt.service.IUserService;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationUserFacadeImplTest {

    @Mock
    IFollowerService followerService;

    @Mock
    IUserService userService;

    @InjectMocks
    ApplicationUserFacadeImpl userFacadeImpl;


    /**
     * Tests USERS
     */
    @Test
    @DisplayName("Test Create User.")
    void createUserTest() {
        //Arrange
        when(userService.createUser(Data.USERDTO_JUAN))
                .then(invocationOnMock -> {
                    Data.USERDTO_JUAN.setUserId(1);
                    return Data.USERDTO_JUAN;
                });

        //Act
        UserDto userDto = userFacadeImpl.createUser(Data.USERDTO_JUAN);

        //Assert
        assertAll(
                () -> assertNotNull(userDto),
                () -> assertEquals("Juan", userDto.getUserName())
        );
        verify(userService).createUser(any(UserDto.class));

    }


    @Test
    @DisplayName("Test  Get All Users.")
    void getAllUsersTest() {
        //Arrange
        when(userService.getAllUsers())
                .thenReturn(List.of(Data.USERDTO_JUAN));

        //Act
        List<UserDto> userDto = userFacadeImpl.getAllUsers();

        //Assert
        assertAll(
                () -> assertNotNull(userDto),
                () -> assertEquals(1, userDto.size())
        );
        verify(userService).getAllUsers();

    }


    @Test
    @DisplayName("Test  Get User By Username.")
    void getUserByUsername() {
        //Arrange
        Data.USERDTO_JUAN.setUserId(1);
        when(userService.getUserByUsername("Juan"))
                .thenReturn(Data.USERDTO_JUAN);

        //Act
        UserDto userDto = userFacadeImpl.getUserByUsername("Juan");

        //Assert
        assertAll(
                () -> assertNotNull(userDto),
                () -> assertEquals(1, userDto.getUserId()),
                () -> assertEquals("Juan", userDto.getUserName())
        );
        verify(userService).getUserByUsername(anyString());

    }


    /**
     * Tests FOLLOWERS
     */

    @Test
    @DisplayName("Test  Follow A Seller.")
    void followASellerTest() {
        //Arrange
        when(userService.getUserById(1))
                .then(invocationOnMock -> {
                    Data.USERDTO_JUAN.setUserId(1);
                    return Data.USERDTO_JUAN;
                });

        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        when(followerService.createFollower(any(FollowerDto.class)))
                .then(invocationOnMock -> {
                    Data.FOLLOWER_DTO_JUAN_PEDRO.setId(1);
                    return Data.FOLLOWER_DTO_JUAN_PEDRO;
                });

        //Act
        String followerTo = userFacadeImpl.followASeller(1, 2);

        //Assert
        assertAll(
                () -> assertNotNull(followerTo),
                () -> assertEquals("El Usuario: Juan ahora sigue al Vendedor: Pedro", followerTo)
        );
        verify(userService).getUserById(1);
        verify(userService).getUserById(2);
        verify(followerService).createFollower(any(FollowerDto.class));

    }


    //Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)
    @Test
    @DisplayName("Test Get Count Followers By Seller.")
    void getCountFollowersBySellerTest() {
        //Arrange
        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        when(followerService.getCountFollowersBySeller(2))
                .thenReturn(2);

        //Act
        UserDto userDto = userFacadeImpl.getCountFollowersBySeller(2);

        //Assert
        assertNotNull(userDto);
        assertEquals("Pedro", userDto.getUserName());
        assertEquals(2, userDto.getFollowersCount());

        verify(userService).getUserById(2);
        verify(followerService).getCountFollowersBySeller(anyInt());
    }


    //Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    @Test
    @DisplayName("Test Get List Followers By Seller.")
    void getAllFollowersBySellerTest() {
        //Arrange
        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        when(followerService.getAllFollowersBySeller(2))
                .thenReturn(List.of(Data.FOLLOWER_DTO_JUAN_PEDRO));

        when(userService.getUserById(1))
                .then(invocationOnMock -> {
                    Data.USERDTO_JUAN.setUserId(1);
                    return Data.USERDTO_JUAN;
                });

        //Act
        UserDto userDto = userFacadeImpl.getAllFollowersBySeller(2, "name_desc");

        //Assert
        assertAll(
                () -> assertNotNull(userDto),
                () -> assertEquals(2, userDto.getUserId()),
                () -> assertEquals("Pedro", userDto.getUserName()),
                () -> assertEquals("Felipe", userDto.getFollowed().get(0).getUserName())
        );
        verify(userService).getUserById(2);
        verify(followerService).getAllFollowersBySeller(anyInt());
        verify(userService).getUserById(1);
    }


    //Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
    @Test
    @DisplayName("Test Get List Followers By Seller successful order.")
    void getAllFollowersBySellerSuccessfulOrderTest() {
        //Arrange
        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        when(followerService.getAllFollowersBySeller(2))
                .thenReturn(List.of(Data.FOLLOWER_DTO_JUAN_PEDRO));

        when(userService.getUserById(1))
                .then(invocationOnMock -> {
                    Data.USERDTO_JUAN.setUserId(1);
                    return Data.USERDTO_JUAN;
                });

        //Act
        UserDto userDto = userFacadeImpl.getAllFollowersBySeller(2, "name_desc");

        //Assert
        assertAll(
                () -> assertNotNull(userDto),
                () -> assertEquals("Juan", userDto.getFollowers().get(0).getUserName()),
                () -> assertEquals(2, userDto.getUserId()),
                () -> assertEquals("Pedro", userDto.getUserName()),
                () -> assertEquals("Felipe", userDto.getFollowed().get(0).getUserName())
        );
        verify(userService).getUserById(2);
        verify(followerService).getAllFollowersBySeller(anyInt());
        verify(userService).getUserById(1);
    }

    //Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    @Test
    @DisplayName("Test Get List Followers By Seller Order Invalid.")
    void getAllFollowersBySellerOrderInvalidTest() {
        //Arrange

        //Act
        //Assert
        OrderNotExistingException e = assertThrows(OrderNotExistingException.class, () -> {
            userFacadeImpl.getAllFollowersBySeller(2, "_desc");
        });

    }

    @Test
    @DisplayName("Test Get List Followed By User.")
    void getListFollowedByUserTest() {
        //Arrange
        when(userService.getUserById(1))
                .then(invocationOnMock -> {
                    Data.USERDTO_JUAN.setUserId(1);
                    return Data.USERDTO_JUAN;
                });

        when(followerService.getListFollowedByUser(1))
                .thenReturn(List.of(Data.FOLLOWER_DTO_JUAN_PEDRO));

        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        //Act
        UserDto userDto = userFacadeImpl.getListFollowedByUser(1, "name_desc");

        //Assert
        assertAll(
                () -> assertNotNull(userDto),
                () -> assertEquals(1, userDto.getUserId()),
                () -> assertEquals("Juan", userDto.getUserName()),
                () -> assertEquals(1, userDto.getFollowed().size())
        );
        verify(userService).getUserById(1);
        verify(followerService).getListFollowedByUser(anyInt());
        verify(userService).getUserById(2);
    }


    @Test
    @DisplayName("Test Unfollow A Seller.")
    void unfollowASellerTest() {
        //Arrange
        when(userService.getUserById(1))
                .then(invocationOnMock -> {
                    Data.USERDTO_JUAN.setUserId(1);
                    return Data.USERDTO_JUAN;
                });

        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        when(followerService.unfollowASeller(1, 2))
                .thenReturn(Data.FOLLOWER_DTO_JUAN_PEDRO);


        //Act
        String unfollowASeller = userFacadeImpl.unfollowASeller(1, 2);

        //Assert
        assertAll(
                () -> assertNotNull(unfollowASeller),
                () -> assertEquals("El Usuario: 1 ahora dejo de seguir al Vendedor: 2", unfollowASeller)
        );

        verify(userService).getUserById(1);
        verify(userService).getUserById(2);
        verify(followerService).unfollowASeller(anyInt(), anyInt());
    }


}