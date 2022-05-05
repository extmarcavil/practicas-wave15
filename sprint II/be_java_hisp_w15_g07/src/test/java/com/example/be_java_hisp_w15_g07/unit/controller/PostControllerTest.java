package com.example.be_java_hisp_w15_g07.unit.controller;

import com.example.be_java_hisp_w15_g07.controller.PostController;
import com.example.be_java_hisp_w15_g07.dto.response.PostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.service.IPostService;
import com.example.be_java_hisp_w15_g07.utils.PostFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Mock
    IPostService service;

    @InjectMocks
    PostController controller;

    @Test
    @DisplayName("T00008 - Verificar filtro de publicaciones recientes de los usuarios seguidos")
    public void returnRecentPostsUsersFollowed(){
        //arrange
        Integer userId = 1;
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //Mockito
        when(service.getFollowedPosts(userId, "date_asc")).thenReturn(new UserFollowedPostsDTO(1, PostFactory.getPostsDTO()));

        //act
        ResponseEntity<UserFollowedPostsDTO> result = controller.getUserFollowedPosts(1, "date_asc");

        // assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        for (PostDTO postDTO: result.getBody().getPosts()) {
            assertTrue(postDTO.getDate().isAfter(twoWeeksAgo));
        }
    }
}
