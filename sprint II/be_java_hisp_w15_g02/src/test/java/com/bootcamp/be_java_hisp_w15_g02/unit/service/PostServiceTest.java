package com.bootcamp.be_java_hisp_w15_g02.unit.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.PostsBySellersDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.service.PostService;
import com.bootcamp.be_java_hisp_w15_g02.service.UserService;
import com.bootcamp.be_java_hisp_w15_g02.unit.utils.Global;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@ExtendWith({MockitoExtension.class})
public class PostServiceTest {

    @Mock
    private IUserRepository userRepository;
    @Mock
    private IPostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("Orden por fecha ascendente")
    void testValidDateOrderAsc() {
        // arrange
        String validOrder = "date_asc";
        int userId = 1;
        User user = Global.getUserByIdUtils(userId);
        List<Post> posts = Global.getPosts();
        Mockito.when(userRepository.getUserById(userId)).thenReturn(user);
        GetPostsSellerByUserIdDTO postsExpected = new GetPostsSellerByUserIdDTO(userId, Global.getRecentPostsAsc());

        List<Follow> followList = user.getFollowList();

        for (Follow f : followList) {
            Mockito.when(postRepository.postsByUser(f.getUserToFollow())).thenReturn(posts);
        }

        // act
        GetPostsSellerByUserIdDTO postsResult = postService.getListPostByFollowIdUser(userId, validOrder);

        // assert
        Assertions.assertEquals(postsExpected, postsResult);
    }

    @Test
    @DisplayName("Orden por fecha descendente")
    void testValidDateOrderDesc() {
        // arrange
        String validOrder = "date_desc";
        int userId = 1;
        User user = Global.getUserByIdUtils(userId);
        List<Post> posts = Global.getPosts();
        Mockito.when(userRepository.getUserById(userId)).thenReturn(user);
        GetPostsSellerByUserIdDTO postsExpected = new GetPostsSellerByUserIdDTO(userId, Global.getRecentPostsDesc());

        List<Follow> followList = user.getFollowList();

        for (Follow f : followList) {
            Mockito.when(postRepository.postsByUser(f.getUserToFollow())).thenReturn(posts);
        }

        // act
        GetPostsSellerByUserIdDTO postsResult = postService.getListPostByFollowIdUser(userId, validOrder);

        // assert
        Assertions.assertEquals(postsExpected, postsResult);
    }

    @Test
    @DisplayName("Orden descendente existente")
    void testDescDateOrderExists() {
        // arrange
        String validOrder = "date_desc";
        int userIdExist = 1;
        User user = Global.getUserByIdUtils(userIdExist);
        List<Post> posts = Global.getPosts();
        Mockito.when(userRepository.getUserById(userIdExist)).thenReturn(user);
        GetPostsSellerByUserIdDTO postsExpected = new GetPostsSellerByUserIdDTO(userIdExist, Global.getRecentPostsDesc());

        List<Follow> followList = user.getFollowList();

        for (Follow f : followList) {
            Mockito.when(postRepository.postsByUser(f.getUserToFollow())).thenReturn(posts);
        }

        // act & assert
        Assertions.assertDoesNotThrow(() -> postService.getListPostByFollowIdUser(userIdExist, validOrder));
    }

    @Test
    @DisplayName("Orden ascendente existente")
    void testAscDateOrderExists() {
        // arrange
        String validOrder = "date_asc";
        int userIdExist = 1;
        User user = Global.getUserByIdUtils(userIdExist);
        List<Post> posts = Global.getPosts();
        Mockito.when(userRepository.getUserById(userIdExist)).thenReturn(user);
        GetPostsSellerByUserIdDTO postsExpected = new GetPostsSellerByUserIdDTO(userIdExist, Global.getRecentPostsDesc());

        List<Follow> followList = user.getFollowList();

        for (Follow f : followList) {
            Mockito.when(postRepository.postsByUser(f.getUserToFollow())).thenReturn(posts);
        }

        // act & assert
        Assertions.assertDoesNotThrow(() -> postService.getListPostByFollowIdUser(userIdExist, validOrder));
    }

    @Test
    @DisplayName("Orden no existente")
    void testDateOrderDoesntExist() {
        // arrange
        String validOrder = "NULL";
        int userIdExist = 1;
        User user = Global.getUserByIdUtils(userIdExist);
        List<Post> posts = Global.getPosts();
        Mockito.when(userRepository.getUserById(userIdExist)).thenReturn(user);
        GetPostsSellerByUserIdDTO postsExpected = new GetPostsSellerByUserIdDTO(userIdExist, Global.getRecentPostsAsc());

        List<Follow> followList = user.getFollowList();

        for (Follow f : followList) {
            Mockito.when(postRepository.postsByUser(f.getUserToFollow())).thenReturn(posts);
        }

        // act & assert
        Assertions.assertThrows(OrderNotFoundException.class, () -> postService.getListPostByFollowIdUser(userIdExist, validOrder));
    }

    @Test
    @DisplayName("Las fechas de las publicaciones son posteriores a hace dos semanas")
    void testPost2WeeksIsCorrect() {
        String validOrder = "date_asc";
        int userIdExist = 1;
        User user = Global.getUserByIdUtils(userIdExist);
        List<Post> posts = Global.getPosts();
        Mockito.when(userRepository.getUserById(userIdExist)).thenReturn(user);
        List<Follow> followList = user.getFollowList();
        for (Follow f : followList) {
            Mockito.when(postRepository.postsByUser(f.getUserToFollow())).thenReturn(posts);
        }
        GetPostsSellerByUserIdDTO postList = postService.getListPostByFollowIdUser(userIdExist, validOrder);
        boolean isNot2week = postList.getPosts().stream().filter(f -> f.getDate().isBefore(LocalDate.now().minusWeeks(2))).count() > 0;
        // act & assert
        Assertions.assertFalse(isNot2week);
    }

    @Test
    @DisplayName("Las fechas de las publicaciones son previas a hace dos semanas")
    void testPost2WeeksIsNotCorrect() {
        String validOrder = "date_asc";
        int userIdExist = 1;
        User user = Global.getUserByIdUtils(userIdExist);
        List<Post> posts = Global.getPosts();
        Mockito.when(userRepository.getUserById(userIdExist)).thenReturn(user);
        List<Follow> followList = user.getFollowList();
        for (Follow f : followList) {
            Mockito.when(postRepository.postsByUser(f.getUserToFollow())).thenReturn(posts);
        }
        GetPostsSellerByUserIdDTO postList = postService.getListPostByFollowIdUser(userIdExist, validOrder);
        PostsBySellersDTO badPost =
                new PostsBySellersDTO(
                        new Post(5,5, LocalDate.now().minusWeeks(3),5,
                                new Product(5,"iphone XR","electronic","apple","white",
                                        "iphone 128 GB"),5000));
        postList.getPosts().add(badPost);
        boolean isNot2week = postList.getPosts().stream().filter(f -> f.getDate().isBefore(LocalDate.now().minusWeeks(2))).count() > 0;
        // act & assert
        Assertions.assertTrue(isNot2week);
    }
}