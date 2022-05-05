package com.example.be_java_hisp_w15_g07.unit.service;

import com.example.be_java_hisp_w15_g07.dto.response.PostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.service.PostService;
import com.example.be_java_hisp_w15_g07.utils.PostFactory;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private IUserRepository repository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("T00008 - Verificar filtro de publicaciones recientes de los usuarios seguidos")
    public void returnRecentPostsUsersFollowed(){
        //arrange
        Integer userId = 1;
        User user1 = UserFactory.getUserOne();
        User user2 = UserFactory.getUserTwo();
        for (Post post: PostFactory.getTwoPostsOneOutdated()) {
            user2.newPost(post);
        }
        User user3 = UserFactory.getUserThree();
        UserFactory.setFollowedList(user1, user2);
        UserFactory.setFollowedList(user1, user3);
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //Mockito
        when(repository.findById(userId)).thenReturn(user1);

        //act
        UserFollowedPostsDTO userFollowedPostsDTO = postService.getFollowedPosts(userId, "date_asc");

        // assert
        assertEquals(1, userFollowedPostsDTO.getUserID());
        for (PostDTO postDTO: userFollowedPostsDTO.getPosts()) {
            assertTrue(postDTO.getDate().isAfter(twoWeeksAgo));
        }
    }
}
