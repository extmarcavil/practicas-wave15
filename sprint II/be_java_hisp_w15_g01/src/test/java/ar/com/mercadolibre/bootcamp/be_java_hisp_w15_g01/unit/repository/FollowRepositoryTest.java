package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.unit.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepositoryImpl;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}
