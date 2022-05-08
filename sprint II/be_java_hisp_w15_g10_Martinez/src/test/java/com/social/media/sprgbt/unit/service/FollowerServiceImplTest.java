package com.social.media.sprgbt.unit.service;

import com.social.media.sprgbt.dto.FollowerDto;
import com.social.media.sprgbt.entity.Follower;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.FollowerMapper;
import com.social.media.sprgbt.repository.IFollowerRepository;
import com.social.media.sprgbt.service.impl.FollowerServiceImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FollowerServiceImplTest {

    /**
     * Mocks
     */
    @Mock
    IFollowerRepository followerRepository;

    @Mock
    private FollowerMapper followerMapper;

    @InjectMocks
    FollowerServiceImpl followerService;

    /**
     * Tests
     */
    @Test
    @DisplayName("Test Create Follower")
    void createFollowerTest() {
        //Arrange
        when(followerMapper.mapToEntity(Data.FOLLOWER_DTO_JUAN_PEDRO)).thenReturn(Data.FOLLOWER_JUAN_PEDRO);

        when(followerRepository.getFollowerByUserIdAndUserIdToFollow(1, 2)).thenReturn(null);

        when(followerRepository.createFollower(Data.FOLLOWER_JUAN_PEDRO)).then(invocationOnMock -> {
            Data.FOLLOWER_JUAN_PEDRO.setId(1);
            return Data.FOLLOWER_JUAN_PEDRO;
        });

        when(followerMapper.mapToDto(Data.FOLLOWER_JUAN_PEDRO)).then(invocationOnMock -> {
            Data.FOLLOWER_DTO_JUAN_PEDRO.setId(1);
            return Data.FOLLOWER_DTO_JUAN_PEDRO;
        });

        //Act
        FollowerDto followerResult = followerService.createFollower(Data.FOLLOWER_DTO_JUAN_PEDRO);

        //Assert
        verify(followerMapper).mapToEntity(any(FollowerDto.class));
        verify(followerRepository).getFollowerByUserIdAndUserIdToFollow(anyInt(), anyInt());
        verify(followerRepository).createFollower(Data.FOLLOWER_JUAN_PEDRO);
        verify(followerMapper).mapToDto(any(Follower.class));

    }

    @Test
    @DisplayName("Test Create Follower Existing")
    void createFollowerExistingTest() {
        //Arrange
        when(followerMapper.mapToEntity(Data.FOLLOWER_DTO_JUAN_PEDRO)).thenReturn(Data.FOLLOWER_JUAN_PEDRO);

        when(followerRepository.getFollowerByUserIdAndUserIdToFollow(1, 2)).then(invocationOnMock -> {
            Data.FOLLOWER_JUAN_PEDRO.setId(1);
            return Data.FOLLOWER_JUAN_PEDRO;
        });

        //Act
        //FollowerDto followerResult = followerService.createFollower(Data.FOLLOWER_DTO_JUAN_PEDRO);
        //Assert
        ExistingException e = assertThrows(ExistingException.class, () -> {
            followerService.createFollower(Data.FOLLOWER_DTO_JUAN_PEDRO);
        });
        assertEquals("El Usuario con userId: 1 ya es seguidor del Usuario con userId: 2.", e.getMessage());
        verify(followerMapper).mapToEntity(any(FollowerDto.class));
        verify(followerRepository).getFollowerByUserIdAndUserIdToFollow(anyInt(), anyInt());
    }

    @Test
    @DisplayName("Test Get Count Followers By Seller.")
    void getCountFollowersBySellerTest() {
        //Arrange
        when(followerRepository.getListFollowersBySeller(2))
                .thenReturn(List.of(Data.FOLLOWER_JUAN_PEDRO, Data.FOLLOWER_FELIPE_PEDRO));

        //Act
        Integer result = followerService.getCountFollowersBySeller(2);

        //Assert
        assertEquals(2, result);
        verify(followerRepository).getListFollowersBySeller(anyInt());

    }

    @Test
    @DisplayName("Test Get All Followers By Seller.")
    void getAllFollowersBySellerTest() {
        //Arrange
        when(followerRepository.getListFollowersBySeller(2))
                .thenReturn(List.of(Data.FOLLOWER_JUAN_PEDRO, Data.FOLLOWER_FELIPE_PEDRO));

        when(followerMapper.mapToDto(Data.FOLLOWER_JUAN_PEDRO)).thenReturn(Data.FOLLOWER_DTO_JUAN_PEDRO);

        //Act
        List<FollowerDto> resultLits = followerService.getAllFollowersBySeller(2);

        //Assert
        assertEquals(2, resultLits.size());
        verify(followerRepository).getListFollowersBySeller(anyInt());
        verify(followerMapper, times(2)).mapToDto(any(Follower.class));

    }

    @Test
    @DisplayName("Test Get All Followed By User.")
    void getListFollowedByUserTest() {
        //Arrange
        when(followerRepository.getListFollowedByUser(1))
                .thenReturn(List.of(Data.FOLLOWER_JUAN_PEDRO));

        when(followerMapper.mapToDto(Data.FOLLOWER_JUAN_PEDRO)).thenReturn(Data.FOLLOWER_DTO_JUAN_PEDRO);

        //Act
        List<FollowerDto> resultLits = followerService.getListFollowedByUser(1);

        //Assert
        assertEquals(1, resultLits.size());
        verify(followerRepository).getListFollowedByUser(anyInt());
        verify(followerMapper, times(1)).mapToDto(any(Follower.class));

    }

    // Verificar que el usuario a dejar de seguir exista. (US-0007)
    @Test
    @DisplayName("Test Unfollow A Seller.")
    void unfollowASellerTest() {
        //Arrange
        when(followerRepository.getFollowerByUserIdAndUserIdToFollow(1, 2))
                .then(invocationOnMock -> {
                    Data.FOLLOWER_JUAN_PEDRO.setId(1);
                    return Data.FOLLOWER_JUAN_PEDRO;
                });

        doNothing().when(followerRepository).deleteFollower(Data.FOLLOWER_JUAN_PEDRO);

        when(followerMapper.mapToDto(Data.FOLLOWER_JUAN_PEDRO)).then(invocationOnMock -> {
            Data.FOLLOWER_DTO_JUAN_PEDRO.setId(1);
            return Data.FOLLOWER_DTO_JUAN_PEDRO;
        });

        //Act
        FollowerDto result = followerService.unfollowASeller(1, 2);

        //Assert
        assertEquals(1, result.getId());
        verify(followerRepository).getFollowerByUserIdAndUserIdToFollow(anyInt(), anyInt());
        verify(followerRepository).deleteFollower(any(Follower.class));
        verify(followerMapper).mapToDto(any(Follower.class));

    }


    // Verificar que el usuario a dejar de seguir exista. (US-0007)
    @Test
    @DisplayName("Test Unfollow A Seller In Existing.")
    void unfollowASellerInExistingTest() {
        //Arrange
        when(followerRepository.getFollowerByUserIdAndUserIdToFollow(10, 20))
                .thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () -> {
            followerService.unfollowASeller(10, 20);
        });
        assertEquals("El Usuario con userId: 10 NO es un seguidor del Usuario con userId: 20.", e.getMessage());
        verify(followerRepository).getFollowerByUserIdAndUserIdToFollow(10, 20);


    }

}