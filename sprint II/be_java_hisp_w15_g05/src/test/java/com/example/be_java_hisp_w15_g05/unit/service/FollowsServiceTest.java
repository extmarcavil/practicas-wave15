package com.example.be_java_hisp_w15_g05.unit.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.OrderNotValidException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FollowsServiceTest {
    @Mock
    IUserRepository userRepository;
    
    @InjectMocks
    FollowsService followsService;

    // T003 - T004
    @Test
    @DisplayName("Verificación de orden alfabetico ascendiente")
    void verificarCorrectoOrdenAlfabetico() {
        //arrange
        User user = UsersFactory.createUserWithFollowers();
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        ResListFollowersDTO resp = followsService.getListFollowers(1,"name_asc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowers());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico descendiente")
    void verificarCorrectoOrdenDescAlfabetico() {
        //arrange
        User user = UsersFactory.createUserWithFollowers();
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfDesc();

        //act
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        ResListFollowersDTO resp = followsService.getListFollowers(1,"name_desc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowers());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico por defecto")
    void verificarCorrectoOrdenDefectoAlfabetico() {
        //arrange
        User user = UsersFactory.createUserWithFollowers();
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
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

    @Test
    @DisplayName("Verificación de orden alfabetico ascendiente de vendedores")
    void correctoOrdenAlfabeticoSellers() {
        //arrange
        User user = UsersFactory.createUserWithFolloweds();
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        when(userRepository.findById(10)).thenReturn(Optional.of(user));
        ResListSellersDTO resp = followsService.getListSellers(10,"name_asc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowed());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico descendiente de vendedores")
    void correctoOrdenAlfabeticoSellersDesc() {
        //arrange
        User user = UsersFactory.createUserWithFolloweds();
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfDesc();

        //act
        when(userRepository.findById(10)).thenReturn(Optional.of(user));
        ResListSellersDTO resp = followsService.getListSellers(10,"name_desc");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowed());
    }

    @Test
    @DisplayName("Verificación de orden alfabetico por defecto de vendedores")
    void correctoOrdenAlfabeticoSellersDefault() {
        //arrange
        User user = UsersFactory.createUserWithFolloweds();
        List<UserDTO> listaOrdenada = UsersFactory.listaOrdenadaAlfAsc();

        //act
        when(userRepository.findById(10)).thenReturn(Optional.of(user));
        ResListSellersDTO resp = followsService.getListSellers(10,"");

        // assert
        Assertions.assertEquals(listaOrdenada,resp.getFollowed());
    }

    @Test
    @DisplayName("Verificación lanzado de excepción sellers")
    void verificarExcepcionOrdenAlfSellers() {
        Assertions
                .assertThrows(
                        OrderNotValidException.class,
                        () -> followsService.getListSellers(10, "cualquierotracosa"));
    }

    // T001 - Follow
    @Test
    @DisplayName("validación de follow camino feliz")
    void verifyFollow() {
        //arrange
        User userVendor = UsersFactory.createUserWithFollowed();
        User userFollow = UsersFactory.createFollower();
        ResFollowPostDTO result = new ResFollowPostDTO("Usuario " + userVendor.getUserId() + " seguido con éxito");

        //act
        //mock
        when(userRepository.findById(userVendor.getUserId())).thenReturn(Optional.of(userVendor));
        when(userRepository.findById(userFollow.getUserId())).thenReturn(Optional.of(userFollow));
        doNothing().when(userRepository).follow(userFollow,userVendor);
        ResFollowPostDTO response = followsService
                .follow(userFollow.getUserId(),userVendor.getUserId());

        verify(userRepository, times(1))
                .follow(userFollow,userVendor);

        //act & assert
        Assertions.assertEquals(result,response);
    }

    @Test
    @DisplayName("validación de existencia de excepcion cuando no encuentra el usuario a seguir")
    void VerifyUserExistenceException() {
        // arrange
        User userFollow = UsersFactory.createFollower();

        // act
        when(userRepository.findById(userFollow.getUserId())).thenReturn(Optional.of(userFollow));
        when(userRepository.findById(30)).thenReturn(Optional.empty());

        // assert
        Assertions.assertThrows(UserNotFoundException.class, () -> followsService
                .follow(userFollow.getUserId(),30));
    }

    // T002 - Unfollow
    @Test
    @DisplayName("validación de unfollow camino feliz")
    void verifyUnfollow() {
        //arrange
        User userVendor = UsersFactory.createUserWithFollowed();
        User userFollow = UsersFactory.createFollower();
        userFollow.seguir(userVendor);
        userVendor.agregarSeguidor(userFollow);
        ResFollowPostDTO result = new ResFollowPostDTO("Usuario " + userVendor.getUserId() + " dejado de seguir");

        // act
        when(userRepository.findById(userVendor.getUserId())).thenReturn(Optional.of(userVendor));
        when(userRepository.findById(userFollow.getUserId())).thenReturn(Optional.of(userFollow));
        doNothing().when(userRepository).unFollow(userFollow,userVendor);
        ResFollowPostDTO response = followsService
                .unFollow(userFollow.getUserId(),userVendor.getUserId());

        verify(
                userRepository,
                times(1))
                    .unFollow(userFollow,userVendor);

        //assert
        Assertions.assertEquals(result,response);
    }
    @Test
    @DisplayName("validación de existencia de excepcion cuando no encuentra el usuario a dejar de seguir")
    void VerifySellerExistenceException() {
        // arrange
        User userFollow = UsersFactory.createFollower();

        // act
        when(userRepository.findById(userFollow.getUserId())).thenReturn(Optional.of(userFollow));
        when(userRepository.findById(30)).thenReturn(Optional.empty());

        // assert
        Assertions.assertThrows(UserNotFoundException.class, () -> followsService
                .unFollow(userFollow.getUserId(),30));
    }

    //T0007 - Count
    @Test
    @DisplayName("Validar cantidad de usuarios seguidores")
    void VerifyQuantityFollowers() {
        //arrange
        User user = UsersFactory.createUserWithFollowers();

        //act
        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.cantFollowers(user)).thenReturn(3);
        ResCountFollowersDTO resultFollow = followsService.countFollowers(user.getUserId());

        //assert
        Assertions.assertEquals(3, resultFollow.getFollowers_count());
    }
}
