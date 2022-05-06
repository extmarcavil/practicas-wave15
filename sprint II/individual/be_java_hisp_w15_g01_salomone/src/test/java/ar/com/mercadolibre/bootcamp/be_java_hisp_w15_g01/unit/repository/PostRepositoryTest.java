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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PostRepositoryTest {

    PostRepository postRepository;

    @BeforeEach
    public void initialize(){
        this.postRepository = new PostRepositoryImpl();
    }

    @Test
    @DisplayName("Listo productos de 14 dias maximo")
    public void test(){
        //arrange
        User u1 = UserFactory.createLuky();

        //act
        postRepository.create(u1,LocalDate.now(), ProductFactory.create(),2,120F);
        postRepository.create(u1,LocalDate.of(2022, 01,01) ,ProductFactory.create() ,2,120F);

        List<Post> result = postRepository.getAllPostsByUserWithinTimespan(u1, 14);

        //assert
        Assertions.assertEquals(1,result.size());
    }
}
