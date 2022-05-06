package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.unit.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepositoryImpl;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.PostFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.ProductFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {
    @Spy
    private PostRepository postRepository = new PostRepositoryImpl();

    @Test
    @DisplayName("Verificar que los posts obtenidos sean de las últimas dos semanas")
    public void test_08_checkPostDate() {
        // Arrange
        User u3 = UserFactory.createGonza();

        Post p1 = PostFactory.create(u3, LocalDate.now().minusDays(5), 1, 23F);
        Post p2 = PostFactory.create(u3, LocalDate.now().minusDays(15), 1, 23F);

        Mockito.when(postRepository.getPosts()).thenReturn(List.of(p1, p2));

        // Act
        List<Post> resultList = postRepository.getAllPostsByUserWithinTimespan(u3, 14);

        // Assert
        Assertions.assertEquals(1, resultList.size());
    }
}
