package com.example.be_java_hisp_w15_g05.unit.service;

import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListSellersDTO;
import com.example.be_java_hisp_w15_g05.dto.UserDTO;
import com.example.be_java_hisp_w15_g05.exceptions.OrderNotValidException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import com.example.be_java_hisp_w15_g05.repository.UserRepository;
import com.example.be_java_hisp_w15_g05.service.FollowsService;
import com.example.be_java_hisp_w15_g05.utils.UsersFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FollowsServiceTest {
    @Mock
    IUserRepository userRepository;
    
    @InjectMocks
    FollowsService followsService;

    // Test getListFollowers
    @Test
    @DisplayName("Verificación de orden alfabetico ascendiente")
    void verificarCorrectoOrdenAlfabetico() {
        //arrange
        User user = UsersFactory.createUserWithFollowers();
        //mockear repo
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        //Crear lista ordenada
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        ResListFollowersDTO resp = followsService.getListFollowers(1,"name_asc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowers());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico descendiente")
    void verificarCorrectoOrdenDescAlfabetico() {
        //arrange
        User user = UsersFactory.createUserWithFollowers();
        //mockear repo
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        //Crear lista ordenada
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfDesc();

        //act
        ResListFollowersDTO resp = followsService.getListFollowers(1,"name_desc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowers());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico por defecto")
    void verificarCorrectoOrdenDefectoAlfabetico() {
        //arrange
        User user = UsersFactory.createUserWithFollowers();
        //mockear repo
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        //Crear lista ordenada
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        ResListFollowersDTO resp = followsService.getListFollowers(1,"");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowers());
    }
    @Test
    @DisplayName("Verificación lanzado de excepción")
    void verificarExcepcionOrdenAlf(){
        Assertions
                .assertThrows(
                        OrderNotValidException.class,
                        () -> followsService.getListFollowers(1,"cualquiercosa"));
    }

<<<<<<< HEAD
    // getListSellers
    @Test
    @DisplayName("Verificación de orden alfabetico ascendiente de vendedores")
    void correctoOrdenAlfabeticoSellers() {
        //arrange
        User user = UsersFactory.createUserWithFolloweds();
        //mockear repo
        when(userRepository.findById(10)).thenReturn(Optional.of(user));
        //Crear lista ordenada
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        ResListSellersDTO resp = followsService.getListSellers(10,"name_asc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowed());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico descendiente de vendedores")
    void correctoOrdenAlfabeticoSellersDesc() {
        //arrange
        User user = UsersFactory.createUserWithFolloweds();
        //mockear repo
        when(userRepository.findById(10)).thenReturn(Optional.of(user));
        //Crear lista ordenada
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfDesc();

        //act
        ResListSellersDTO resp = followsService.getListSellers(10,"name_desc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowed());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico por defecto de vendedores")
    void correctoOrdenAlfabeticoSellersDefault() {
        //arrange
        User user = UsersFactory.createUserWithFolloweds();
        //mockear repo
        when(userRepository.findById(10)).thenReturn(Optional.of(user));
        //Crear lista ordenada
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        ResListSellersDTO resp = followsService.getListSellers(10,"");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowed());
    }

    @Test
    @DisplayName("Verificación lanzado de excepción sellers")
    void verificarExcepcionOrdenAlfSellers(){
        Assertions
                .assertThrows(
                        OrderNotValidException.class,
                        () -> followsService.getListSellers(10,"cualquierotracosa"));
=======
    // T001

    @Test
    @DisplayName("validación de existencia de usuario a seguir")
    void VerifyUserExistence() {

        //arrange
        User expectedSeller = new User(20, "Juan", true);
        User expectedFollower = new User(30, "Miguel", false);

        //act & assert
        Assertions.assertThrows(UserNotFoundException.class, () -> followsService
                .follow(expectedFollower.getUserId(),expectedSeller.getUserId()));
    }

    // T002

    @Test
    @DisplayName("validación de existencia de usuario a dejar de seguir")
    void VerifyUserToUnfollowExistenceTestException() {

        //arrange
        User expectedSeller = new User(20, "Juan", true);
        User expectedFollower = new User(30, "Miguel", false);

        //act & assert
        Assertions.assertThrows(UserNotFoundException.class, () -> followsService
                .unFollow(expectedFollower.getUserId(),expectedSeller.getUserId()));
>>>>>>> ej1
    }
}
