package com.social.media.sprgbt.unit.service;

import com.social.media.sprgbt.dto.PostDto;
import com.social.media.sprgbt.entity.Post;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.PostMapper;
import com.social.media.sprgbt.repository.IPostRepository;
import com.social.media.sprgbt.service.impl.PostServiceImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {


    /**
     * Mocks
     */
    @Mock
    private PostMapper postMapper;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    PostServiceImpl postServiceImpl;


    /**
     * Tests
     */
    @Test
    @DisplayName("Test Create Post")
    void createPostTest() {
        //Arrange
        when(postMapper.mapToEntity(Data.POSTDTO_1)).thenReturn(Data.POST_1);

        when(postRepository.createPost(Data.POST_1)).then(invocationOnMock -> {
            Data.POST_1.setPostId(1);
            return Data.POST_1;
        });

        when(postMapper.mapToDto(Data.POST_1)).then(invocationOnMock -> {
            Data.POSTDTO_1.setPostId(1);
            return Data.POSTDTO_1;
        });

        //Act
        PostDto result = postServiceImpl.createPost(Data.POSTDTO_1);


        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getPostId()),
                () -> assertEquals(Data.POSTDTO_1.getProductoDto(), result.getProductoDto()),
                () -> assertEquals(Data.POSTDTO_1.getDate(), result.getDate()),
                () -> assertEquals(Data.POSTDTO_1.getPrice(), result.getPrice()),
                () -> assertEquals(Data.POSTDTO_1.getCategory(), result.getCategory()),
                () -> assertEquals(Data.POSTDTO_1.isHasPromo(), result.isHasPromo()),
                () -> assertEquals(Data.POSTDTO_1.getDiscount(), result.getDiscount())
        );
        verify(postMapper).mapToEntity(any(PostDto.class));
        verify(postRepository).createPost(any(Post.class));
        verify(postMapper).mapToDto(any(Post.class));
    }


    @Test
    @DisplayName("Test Get Post By User Id With ProductId")
    void getPostByUserIdWithProductIdTest() {
        //Arrange
        when(postRepository.getPostByUserIdWithProductId(1, 1)).then(invocationOnMock -> {
            Data.POST_1.setPostId(1);
            return Data.POST_1;
        });

        when(postMapper.mapToDto(Data.POST_1)).then(invocationOnMock -> {
            Data.POSTDTO_1.setPostId(1);
            return Data.POSTDTO_1;
        });

        //Act
        PostDto result = postServiceImpl.getPostByUserIdWithProductId(1, 1);

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getPostId()),
                () -> assertEquals(Data.POSTDTO_1.getProductoDto(), result.getProductoDto()),
                () -> assertEquals(Data.POSTDTO_1.getDate(), result.getDate()),
                () -> assertEquals(Data.POSTDTO_1.getPrice(), result.getPrice()),
                () -> assertEquals(Data.POSTDTO_1.getCategory(), result.getCategory()),
                () -> assertEquals(Data.POSTDTO_1.isHasPromo(), result.isHasPromo()),
                () -> assertEquals(Data.POSTDTO_1.getDiscount(), result.getDiscount())
        );
        verify(postRepository).getPostByUserIdWithProductId(anyInt(), anyInt());
        verify(postMapper).mapToDto(any(Post.class));
    }


    @Test
    @DisplayName("Test Get Post By User Id With ProductId Not Found")
    void getPostByUserIdWithProductIdNotFoundTest() {
        //Arrange
        when(postRepository.getPostByUserIdWithProductId(1, 1)).thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () -> {
            postServiceImpl.getPostByUserIdWithProductId(1, 1);
        });
        assertEquals("No hay coincidencias para userId: 1 y productId: 1.", e.getMessage());
        verify(postRepository).getPostByUserIdWithProductId(anyInt(), anyInt());

    }


    @Test
    @DisplayName("Test Get All Post By User")
    void getAllPostByUserTest() {
        //Arrange
        when(postRepository.getAllPostByUser(3)).thenReturn(Arrays.asList(Data.POST_2));

        when(postMapper.mapToDto(Data.POST_2)).thenReturn(Data.POSTDTO_2);

        //Act
        List<PostDto> resultList = postServiceImpl.getAllPostByUser(3);

        //Assert
        assertAll(
                () -> assertNotNull(resultList),
                () -> assertEquals(1, resultList.size()),
                () -> assertEquals(Data.POSTDTO_2.getUserId(), resultList.get(0).getUserId())
        );
        verify(postRepository).getAllPostByUser(anyInt());
        verify(postMapper).mapToDto(any(Post.class));

    }

}