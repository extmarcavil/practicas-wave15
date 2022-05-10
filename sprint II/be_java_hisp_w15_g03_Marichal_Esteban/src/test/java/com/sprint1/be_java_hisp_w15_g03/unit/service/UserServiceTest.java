package com.sprint1.be_java_hisp_w15_g03.unit.service;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.RelationConflictException;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import com.sprint1.be_java_hisp_w15_g03.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IMeliRepository meliRepository;

    @InjectMocks
    UserService userService;

    //T-0001
    @Test
    @DisplayName("Seguir a un vendedor correctamente.")
    void followSeller() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(false);

        //Act
        userService.followSeller(1, 1);

        //Assert
        verify(meliRepository, atLeastOnce()).followSeller(anyInt(), anyInt());
    }

    //T-0001
    @Test
    @DisplayName("Se intenta seguir a un vendedor con un usuario inexistente: PersonNotFoundException")
    void followSellerUserNotFoundException() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(false);

        //Act Assert
        assertThrows(PersonNotFoundException.class,
                () -> userService.followSeller(1, 1));
    }

    //T-0001
    @Test
    @DisplayName("Se intenta seguir a un vendedor inexistente: PersonNotFoundException")
    void followSellerSellerNotFoundException() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(false);

        //Act Assert
        assertThrows(PersonNotFoundException.class,
                () -> userService.followSeller(1, 1));
    }

    //T-0001
    @Test
    @DisplayName("Se intenta seguir a un vendedor al cual ya se sigue: RelationConflictException")
    void followSellerRelationConflictException() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(true);

        //Act Assert
        assertThrows(RelationConflictException.class,
                () -> userService.followSeller(1, 1));
    }

    //T-0002
    @Test
    @DisplayName("Se deja de seguir a un vendedor correctamente")
    void unFollowSeller() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(true);

        //Act
        userService.unFollowSeller(1, 1);

        //Assert
        verify(meliRepository, atLeastOnce()).unFollowSeller(anyInt(), anyInt());
    }

    //T-0002
    @Test
    @DisplayName("Se intenta dejar de seguir a un vendedor con un usuario inexistente: PersonNotFoundException")
    void unFollowSellerUserNotFoundException() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(false);

        //Act Assert
        assertThrows(PersonNotFoundException.class,
                () -> userService.unFollowSeller(1, 1));
    }

    //T-0002
    @Test
    @DisplayName("Se intenta dejar de seguir a un vendedor con un vendedor inexistente: PersonNotFoundException")
    void unFollowSellerSellerNotFoundException() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(false);

        //Act Assert
        assertThrows(PersonNotFoundException.class,
                () -> userService.unFollowSeller(1, 1));
    }

    //T-0002
    @Test
    @DisplayName("Se intenta dejar de seguir a un vendedor que no se seguía: RelationConflictException")
    void unFollowSellerRelationConflictException() {
        //Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(false);

        //Act Assert
        assertThrows(RelationConflictException.class,
                () -> userService.unFollowSeller(1, 1));
    }

    //T-0003
    @Test
    @DisplayName("En lista de followers verificar que el tipo de ordenamiento alfabético exista.")
    void getFollowersList() {
        //Arrange
        Seller seller = new Seller();
        seller.setUserName("Netflix");
        seller.setUserId(43);
        seller.setFollowers(new ArrayList<>());
        // Mock
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.getSeller(anyInt())).thenReturn(seller);

        //Act Assert
        assertDoesNotThrow(() -> userService.getFollowersList(seller.getUserId(), "name_asc"));
    }

    //T-0003
    @Test
    @DisplayName("En lista de followers verificar que el tipo de ordenamiento alfabético no exista: OrderInvalidException.")
    void getFollowersListOrderInvalidException() {
        //Arrange
        Seller seller = new Seller();
        seller.setUserName("Netflix");
        seller.setUserId(43);
        seller.setFollowers(new ArrayList<>());
        // Mock
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.getSeller(anyInt())).thenReturn(seller);
        //Act Assert
        assertThrows(OrderInvalidException.class, () -> userService.getFollowersList(seller.getUserId(), "no_existe"));
    }

    //T-0003
    @Test
    @DisplayName("En lista de followed verificar que el tipo de ordenamiento alfabético exista.")
    void getFollowedList() {
        User user = new User();
        user.setUserName("Jose");
        user.setUserId(43);
        user.setFollowed(new ArrayList<>());
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.getUser(anyInt())).thenReturn(user);

        //Act Assert
        assertDoesNotThrow(() -> userService.getFollowedList(user.getUserId(), "name_asc"));
    }

    //T-0003
    @Test
    @DisplayName("En lista de followed verificar que el tipo de ordenamiento alfabético no exista: OrderInvalidException.")
    void getFollowedListOrderInvalidException() {
        User user = new User();
        user.setUserName("Jose");
        user.setUserId(43);
        user.setFollowed(new ArrayList<>());
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.getUser(anyInt())).thenReturn(user);

        //Act Assert
        assertThrows(OrderInvalidException.class, () -> userService.getFollowedList(user.getUserId(), "no_existe"));
    }

    //T-0004
    @Test
    @DisplayName("En lista de followers verificar que el tipo de ordenamiento ascendente alfabético sea correcto.")
    void getFollowersListAsc() {
        //Arrange
        Seller seller = new Seller();
        seller.setUserName("Netflix");
        seller.setUserId(43);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserId(123);
        user.setUserName("Carlos");
        User user1 = new User();
        user1.setUserId(321);
        user1.setUserName("Andres");
        users.add(user);
        users.add(user1);
        seller.setFollowers(users);

        // Mock
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.getSeller(anyInt())).thenReturn(seller);

        //Act
        List<PersonDTO> response = userService.getFollowersList(seller.getUserId(), "name_asc").getFollowers();

        // Assert
        assertAll(
                () -> assertEquals(response.get(0).getUserName(), user1.getUserName()),
                () -> assertEquals(response.get(1).getUserName(), user.getUserName())
        );
    }

    //T-0004
    @Test
    @DisplayName("En lista de followers verificar que el tipo de ordenamiento descendiente alfabético sea correcto.")
    void getFollowersListDesc() {
        //Arrange
        Seller seller = new Seller();
        seller.setUserName("Netflix");
        seller.setUserId(43);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserId(123);
        user.setUserName("Andres");
        User user1 = new User();
        user1.setUserId(321);
        user1.setUserName("Carlos");
        users.add(user);
        users.add(user1);
        seller.setFollowers(users);

        // Mock
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.getSeller(anyInt())).thenReturn(seller);

        //Act
        List<PersonDTO> response = userService.getFollowersList(seller.getUserId(), "name_desc").getFollowers();

        // Assert
        assertAll(
                () -> assertEquals(response.get(0).getUserName(), user1.getUserName()),
                () -> assertEquals(response.get(1).getUserName(), user.getUserName())
        );
    }

    //T-0004
    @Test
    @DisplayName("En lista de followed verificar el correcto ordenamiento ascendente por nombre.")
    void getFollowedListAsc() {
        //Arrange
        User user = new User();
        user.setUserName("Carlos");
        user.setUserId(43);
        List<Seller> sellers = new ArrayList<>();
        Seller seller = new Seller();
        seller.setUserId(123);
        seller.setUserName("Netflix");
        Seller seller1 = new Seller();
        seller1.setUserId(321);
        seller1.setUserName("Amazon");
        sellers.add(seller);
        sellers.add(seller1);
        user.setFollowed(sellers);

        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.getUser(anyInt())).thenReturn(user);

        //Act
        List<PersonDTO> response = userService.getFollowedList(user.getUserId(), "name_asc").getFollowed();

        // Assert
        assertAll(
                () -> assertEquals(response.get(0).getUserName(), seller1.getUserName()),
                () -> assertEquals(response.get(1).getUserName(), seller.getUserName())
        );
    }

    //T-0004
    @Test
    @DisplayName("En lista de followed verificar el correcto ordenamiento descendente por nombre.")
    void getFollowedListDesc() {
        //Arrange
        User user = new User();
        user.setUserName("Carlos");
        user.setUserId(43);
        List<Seller> sellers = new ArrayList<>();
        Seller seller = new Seller();
        seller.setUserId(123);
        seller.setUserName("Amazon");
        Seller seller1 = new Seller();
        seller1.setUserId(321);
        seller1.setUserName("Netflix");
        sellers.add(seller);
        sellers.add(seller1);
        user.setFollowed(sellers);

        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.getUser(anyInt())).thenReturn(user);

        //Act
        List<PersonDTO> response = userService.getFollowedList(user.getUserId(), "name_desc").getFollowed();

        // Assert
        assertAll(
                () -> assertEquals(response.get(0).getUserName(), seller1.getUserName()),
                () -> assertEquals(response.get(1).getUserName(), seller.getUserName())
        );
    }

    // Extra
    @Test
    @DisplayName("En lista de followed verificar que el tipo de ordenamiento alfabético exista con usuario inexistente: PersonNotFoundException.")
    void getFollowedListPersonNotFoundException() {
        // Mock
        when(meliRepository.hasUser(anyInt())).thenReturn(false);
        //Act Assert
        assertThrows(PersonNotFoundException.class, () -> userService.getFollowedList(1, "name_asc"));
    }

    // Extra
    @Test
    @DisplayName("En lista de followers verificar que el tipo de ordenamiento alfabético exista con usuario inexistente: PersonNotFoundException.")
    void getFollowersListPersonNotFoundException() {
        // Mock
        when(meliRepository.hasSeller(anyInt())).thenReturn(false);
        //Act Assert
        assertThrows(PersonNotFoundException.class, () -> userService.getFollowersList(1, "name_desc"));
    }


    //T-0007
    @Test
    @DisplayName("Verificar que la cantidad de seguidores de un usuario sea correcta")
    void getFollowersCountOk(){
        //arrange
        Seller seller = new Seller();
        seller.setUserName("Netflix");
        seller.setUserId(43);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserId(123);
        user.setUserName("Andres");
        User user1 = new User();
        user1.setUserId(321);
        user1.setUserName("Carlos");
        users.add(user);
        users.add(user1);
        seller.setFollowers(users);

        //Mock
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.getSeller(anyInt())).thenReturn(seller);


        //act
        SellerCountDTO sellerCount = userService.getFollowersCount(seller.getUserId());

        //assert
        assertEquals(sellerCount.getFollowersCount(), seller.getFollowers().size());

    }

    //T-0007
    @Test
    @DisplayName("Verificar cantidad de seguidores con vendedor que no existe: PersonNotFoundException")
    void getFollowersCountNotOk(){
        //Mock
        when(meliRepository.hasSeller(anyInt())).thenReturn(false);

        //act & assert
        assertThrows(PersonNotFoundException.class, () -> userService.getFollowersCount(1));

    }

}
