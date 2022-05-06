package com.sprint1.be_java_hisp_w15_g03.unit.repository;

import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(user.getFollowed().size() > 0);
        assertTrue(seller.getFollowers().size() > 0);
    }

    //T-0001
    @Test
    @DisplayName("Usuario o vendedor inexistente: NullPointerException")
    void followSellerNullPointerException() {
        //Arrange
        //Act & Assert
        assertThrows(NullPointerException.class,
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
        assertEquals(0, seller.getFollowers().size());
        assertEquals(0, user.getFollowed().size());
    }

    //T-0002
    @Test
    @DisplayName("Usuario o vendedor inexistente: NullPointerException")
    void unFollowSellerNullPointerException() {
        //Arrange
        //Act & Assert
        assertThrows(NullPointerException.class,
                () -> meliRepository.unFollowSeller(0, 0));
    }

    //T-0008
    @Test
    @DisplayName("Verificar las ultimas publicaciones de un vendedor sean correctas")
    void getLastPublicationsOk() {
        //Arrange

        Seller seller = new Seller();
        seller.setFollowers(new ArrayList<>());
        seller.setPublications(new ArrayList<>());
        seller.setUserName("Garbarino");

        User user = new User();
        user.setFollowed(new ArrayList<>());
        user.getFollowed().add(seller);
        user.setUserName("Maria");

        seller.getFollowers().add(user);

        Publication publication1 = new Publication(1, LocalDate.now(), Category.MESA, 300.0, null,
                null, null);
        Publication publication2 = new Publication(2, LocalDate.now().minus(3, ChronoUnit.WEEKS),
                Category.MESA, 300.0, null, null, null);

        seller = meliRepository.addSeller(seller);
        user = meliRepository.addUser(user);
        meliRepository.savePublication(seller.getUserId(), publication1);
        meliRepository.savePublication(seller.getUserId(), publication2);

        //Act
        List<Publication> publications = meliRepository.getLastPublications(user.getUserId());

        //Assert
        assertAll(
                () -> assertEquals(publications.size(), 1),
                () -> assertEquals(publications.get(0).getPostId(), publication1.getPostId()),
                () -> assertTrue(publications.get(0).getDate()
                        .isAfter(LocalDate.now().minus(2, ChronoUnit.WEEKS)))
        );
    }

    // Extra
    @Test
    @DisplayName("Verificación de que un usuario siga a un vendedor o si un vendedor es seguido por un usuario")
    void followingTrue() {
        Seller seller = new Seller();
        seller.setFollowers(new ArrayList<>());
        seller.setUserName("Garbarino");

        User user = new User();
        user.setFollowed(new ArrayList<>());
        user.getFollowed().add(seller);
        user.setUserName("Maria");

        seller.getFollowers().add(user);

        seller = meliRepository.addSeller(seller);
        user = meliRepository.addUser(user);

        assertTrue(meliRepository.following(user.getUserId(), seller.getUserId()));
    }

    // Extra
    @Test
    @DisplayName("Verificación de que un usuario siga a un vendedor o si un vendedor es seguido por un usuario")
    void followingFalse() {
        Seller seller = new Seller();
        seller.setFollowers(new ArrayList<>());
        seller.setUserName("Garbarino");

        User user = new User();
        user.setFollowed(new ArrayList<>());
        user.setUserName("Maria");

        seller = meliRepository.addSeller(seller);
        user = meliRepository.addUser(user);

        assertFalse(meliRepository.following(user.getUserId(), seller.getUserId()));
    }
}
