package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.unit.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.NotFollowedException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepositoryImpl;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FollowRepositoryTest {
    private FollowRepository followRepository;

    @BeforeEach
    public void initiliaze() {
        this.followRepository = new FollowRepositoryImpl();
    }

    @Test
    @DisplayName("Un usuario puede seguir a otro que si existe")
    public void test_01_follow() {
        // Arrange
        User luky = UserFactory.createLuky();
        User gonza = UserFactory.createGonza();
        User luky2 = UserFactory.createLuky();
        User gonza2 = UserFactory.createGonza();

        // Act
        followRepository.save(luky, gonza);

        // Assert
        Assertions.assertTrue(followRepository.existByFollowerAndFollowed(luky2, gonza2));
    }


    @Test
    @DisplayName("Un usuario no puede dejar de seguir a uno que no sigue")
    public void testNotFollowedException(){
        //arrange
        User luky = UserFactory.createLuky();
        User gonza = UserFactory.createGonza();

        //act & assert
        Assertions.assertThrows(NotFollowedException.class, () -> followRepository.unFollow(luky, gonza));
    }


    @Test
    @DisplayName("Quien sigue al id parametro")
    public void testWhoFollows(){
        //arrange
        Long idUser = 3L;
        User u1 = UserFactory.createJesu();
        User u2 = UserFactory.createGonza();
        User u3 = UserFactory.createLuky();

        followRepository.save(u1, u2);
        followRepository.save(u3,u2);

        //act
        List<Follow> lista = followRepository.whoFollows(idUser);

        //assert
        Assertions.assertEquals(2,lista.size());
    }

    @Test
    @DisplayName("Cantidad de seguidos a partir de un id")
    public void testWhoFollowedByUser(){
        //arrange
        Long idUser = 2L;
        User u1 = UserFactory.createJesu();
        User u2 = UserFactory.createGonza();
        User u3 = UserFactory.createLuky();
        followRepository.save(u1, u2);
        followRepository.save(u1, u3);

        //act
        List<User> lista = followRepository.findFollowedByUserId(idUser);

        //assert
        Assertions.assertEquals(2,lista.size());
    }


}
