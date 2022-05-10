package com.sprint1.be_java_hisp_w15_g4.unit;

import Utils.TestGenerator;
import com.sprint1.be_java_hisp_w15_g4.dto.response.PostListDTO;
import com.sprint1.be_java_hisp_w15_g4.model.Post;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint1.be_java_hisp_w15_g4.service.ProductService;
import com.sprint1.be_java_hisp_w15_g4.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class T0006 {

    @Mock
    private IUserRepository repo;

    @InjectMocks
    private ProductService productService;


    @Test
    @DisplayName("Verifica el orden por fecha ascendente de los productos")
    void verifyProductAscOrder () {

        // Arrange
        User buyer = TestGenerator.GenerateUser(1, "José");
        User seller = TestGenerator.GenerateUser(2, "Juan");

        buyer.addFollowing(seller);

        Post post1 = TestGenerator.GeneratePosts(2,"2022-05-04");
        Post post2 = TestGenerator.GeneratePosts(2,"2022-04-30");
        Post post3 = TestGenerator.GeneratePosts(2,"2022-05-01");

        seller.addPost(post1);
        seller.addPost(post2);
        seller.addPost(post3);

        // Mock
        Mockito.when(repo.findUser(1)).thenReturn(buyer);

        // Act
        PostListDTO orderedPosts = productService.lastTwoWeeksPosts(buyer.getUser_id(), "date_asc");

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(post2.getDate(), orderedPosts.getPosts().get(0).getDate()),
                () -> Assertions.assertEquals(post3.getDate(), orderedPosts.getPosts().get(1).getDate()),
                () -> Assertions.assertEquals(post1.getDate(), orderedPosts.getPosts().get(2).getDate())
        );
    }

    @Test
    @DisplayName("Verifica el orden por fecha descendente de los productos")
    void verifyProductDescOrder () {

        // Arrange
        User buyer = TestGenerator.GenerateUser(1, "José");
        User seller = TestGenerator.GenerateUser(2, "Juan");

        buyer.addFollowing(seller);

        Post post1 = TestGenerator.GeneratePosts(2,"2022-05-04");
        Post post2 = TestGenerator.GeneratePosts(2,"2022-04-30");
        Post post3 = TestGenerator.GeneratePosts(2,"2022-05-01");

        seller.addPost(post1);
        seller.addPost(post2);
        seller.addPost(post3);

        // Mock
        Mockito.when(repo.findUser(1)).thenReturn(buyer);

        // Act
        PostListDTO orderedPosts = productService.lastTwoWeeksPosts(buyer.getUser_id(), "date_desc");

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(post1.getDate(), orderedPosts.getPosts().get(0).getDate()),
                () -> Assertions.assertEquals(post3.getDate(), orderedPosts.getPosts().get(1).getDate()),
                () -> Assertions.assertEquals(post2.getDate(), orderedPosts.getPosts().get(2).getDate())
        );
    }
}
