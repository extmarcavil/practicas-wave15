package com.sprint1.be_java_hisp_w15_g03.unit.repository;

import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MeliRepositoryTest {

    MeliRepository meliRepository;

    @BeforeEach
    void setup() {
        meliRepository = new MeliRepository();
    }

    //T-0001
    @Test
    @DisplayName("Seguir a un vendedor correctamente.")
    void followSeller() {
        //Arrange
        User user = new User();
        user.setFollowed(new ArrayList<>());
        user.setUserName("Maria");
        Seller seller = new Seller();
        seller.setUserName("Garbarino");
        seller.setFollowers(new ArrayList<>());

        user = meliRepository.addUser(user);
        seller = meliRepository.addSeller(seller);
        //Act
        meliRepository.followSeller(
                user.getUserId(),
                seller.getUserId());
        //Assert
        Assertions.assertTrue(user.getFollowed().size() > 0);
        Assertions.assertTrue(seller.getFollowers().size() > 0);
    }

    //T-0001
    @Test
    @DisplayName("Usuario o vendedor inexistente: NullPointerException")
    void followSellerNullPointerException() {
        //Arrange
        //Act & Assert
        Assertions.assertThrows(NullPointerException.class,
                () -> meliRepository.followSeller(0, 0));
    }

    //T-0002
    @Test
    @DisplayName("Dejar de seguir a un vendedor correctamente.")
    void unFollowSeller() {
        //Arrange
        User user = new User();
        user.setFollowed(new ArrayList<>());
        user.setUserName("Maria");
        Seller seller = new Seller();
        seller.setUserName("Garbarino");
        seller.setFollowers(new ArrayList<>());

        user = meliRepository.addUser(user);
        seller = meliRepository.addSeller(seller);
        seller.getFollowers().add(user);
        user.getFollowed().add(seller);

        //Act
        meliRepository.unFollowSeller(user.getUserId(), seller.getUserId());

        //Assert
        Assertions.assertEquals(0, seller.getFollowers().size());
        Assertions.assertEquals(0, user.getFollowed().size());
    }

    //T-0002
    @Test
    @DisplayName("Usuario o vendedor inexistente: NullPointerException")
    void unFollowSellerNullPointerException() {
        //Arrange
        //Act & Assert
        Assertions.assertThrows(NullPointerException.class,
                () -> meliRepository.unFollowSeller(0, 0));
    }
}
