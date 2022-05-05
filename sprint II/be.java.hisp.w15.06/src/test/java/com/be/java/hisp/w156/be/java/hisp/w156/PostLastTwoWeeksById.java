package com.be.java.hisp.w156.be.java.hisp.w156;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import com.be.java.hisp.w156.be.java.hisp.w156.service.ProductServiceImpl;
import com.be.java.hisp.w156.be.java.hisp.w156.util.PostLasTwoWeeksByIdFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.be.java.hisp.w156.be.java.hisp.w156.util.PostLasTwoWeeksByIdFactory.getListPostLast2Weeks;

@ExtendWith(MockitoExtension.class)
public class PostLastTwoWeeksById {

    @Mock
    IUserRepository repository;

    @InjectMocks
    ProductServiceImpl service;

    @Test
    @DisplayName("Verificar  la consulta de publicaciones realizadas sean de las ultimas 2 semanas ")
    public void whenGetPostsLastTwoWeekById(){
        //arrange
        int userId = 1;
        String order = "date_asc";

        Mockito.when(repository.getUser(userId)).thenReturn(getListPostLast2Weeks());

        List<ResponsePostDTO> expected = PostLasTwoWeeksByIdFactory.getPosts();

        //act
        ResponseEntity<RecentlyPostDTO> result = service.getPostsLastTwoWeekById(userId, order);

        //asset
        Assertions.assertArrayEquals(expected.toArray(), result.getBody().getPosts().toArray());
    }
}
