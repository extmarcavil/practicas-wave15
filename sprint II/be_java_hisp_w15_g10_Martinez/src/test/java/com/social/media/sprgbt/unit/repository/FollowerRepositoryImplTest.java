package com.social.media.sprgbt.unit.repository;

import com.social.media.sprgbt.entity.Follower;
import com.social.media.sprgbt.entity.User;
import com.social.media.sprgbt.repository.IFollowerRepository;
import com.social.media.sprgbt.repository.impl.FollowerRepositoryImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class FollowerRepositoryImplTest {

    /**
     * Instancia de la clase a testear FollowerRepositoryImpl.
     */
    private IFollowerRepository followerRepositoryImpl;


    @BeforeEach
    void setUp() {
        followerRepositoryImpl = new FollowerRepositoryImpl();
        FollowerRepositoryImpl.listFollowers = new ArrayList<>();
        FollowerRepositoryImpl.count = new AtomicInteger(0);
    }


    @Test
    @DisplayName("Test Juan con Id 1 Seguidor de Pedro con Id 2")
    void createUserTest() {
        //Arrange
        Follower juan = Data.FOLLOWER_JUAN_PEDRO;

        //Act
        Follower result = followerRepositoryImpl.createFollower(juan);

        //Assert
        assertAll(
                () -> assertTrue(result != null),
                () -> assertEquals(1, result.getId()),
                () -> assertEquals(juan.getUserId(), result.getUserId()),
                () -> assertEquals(juan.getUserIdToFollow(), result.getUserIdToFollow())
        );
    }


    @Test
    @DisplayName("Test Get Follower By UserId And UserIdToFollow")
    void getFollowerByUserIdAndUserIdToFollowTest() {
        //Arrange
        Follower follower = followerRepositoryImpl.createFollower(Data.FOLLOWER_JUAN_PEDRO);

        //Act
        Follower getFollower = followerRepositoryImpl.getFollowerByUserIdAndUserIdToFollow(1, 2);

        //Assert
        assertAll(

                () -> assertNotNull(getFollower),
                () -> assertEquals(follower, getFollower),
                () -> assertEquals(follower.getId(), getFollower.getId()),
                () -> assertEquals(follower.getUserId(), getFollower.getUserId()),
                () -> assertEquals(follower.getUserIdToFollow(), getFollower.getUserIdToFollow())
        );
    }

    @Test
    @DisplayName("Test Get Follower By UserId And UserIdToFollow Not Found")
    void getFollowerByUserIdAndUserIdToFollowNullTest() {
        //Arrange
        Follower juan = Data.FOLLOWER_JUAN_PEDRO;

        //Act
        Follower getFollower = followerRepositoryImpl.getFollowerByUserIdAndUserIdToFollow(1, 2);

        //Assert
        assertNull(getFollower);
    }


    @Test
    @DisplayName("Test Get List All Followers.")
    void getListAllFollowersTest() {
        //Arrange
        Follower juan = Data.FOLLOWER_JUAN_PEDRO;
        Follower pedro = Data.FOLLOWER_PEDRO_FELIPE;
        Follower felipe = Data.FOLLOWER_FELIPE_PEDRO;

        followerRepositoryImpl.createFollower(juan);
        followerRepositoryImpl.createFollower(pedro);
        followerRepositoryImpl.createFollower(felipe);

        //Act
        List<Follower> getFollowers = followerRepositoryImpl.getListAllFollowers();

        //Assert
        assertAll(
                () -> assertNotNull(getFollowers),
                () -> assertEquals(3, getFollowers.size()),
                () -> assertEquals(1, getFollowers.get(0).getId()),
                () -> assertEquals(1, getFollowers.get(0).getUserId()),
                () -> assertEquals(2, getFollowers.get(0).getUserIdToFollow())

        );
    }


    @Test
    @DisplayName("Test Get List Followers By SellerId.")
    void getListFollowersBySellerTest() {
        //Arrange
        Follower juan = Data.FOLLOWER_JUAN_PEDRO;
        Follower pedro = Data.FOLLOWER_PEDRO_FELIPE;
        Follower felipe = Data.FOLLOWER_FELIPE_PEDRO;

        followerRepositoryImpl.createFollower(juan);
        followerRepositoryImpl.createFollower(pedro);
        followerRepositoryImpl.createFollower(felipe);

        //Act
        List<Follower> listFollowersBySeller = followerRepositoryImpl.getListFollowersBySeller(2);

        //Assert
        assertAll(
                () -> assertNotNull(listFollowersBySeller),
                () -> assertEquals(2, listFollowersBySeller.size()),
                () -> assertEquals(2, listFollowersBySeller.get(0).getUserIdToFollow()),
                () -> assertEquals(2, listFollowersBySeller.get(1).getUserIdToFollow())

        );
    }

    @Test
    @DisplayName("Test Get List Followed By User.")
    void getListFollowedByUserTest() {
        //Arrange
        Follower pedro_Juan = Data.FOLLOWER_PEDRO_JUAN;
        Follower pedro_Felipe = Data.FOLLOWER_PEDRO_FELIPE;

        followerRepositoryImpl.createFollower(pedro_Juan);
        followerRepositoryImpl.createFollower(pedro_Felipe);

        //Act
        List<Follower> listFollowersByUser = followerRepositoryImpl.getListFollowedByUser(2);

        //Assert
        assertAll(
                () -> assertNotNull(listFollowersByUser),
                () -> assertEquals(2, listFollowersByUser.size()),
                () -> assertEquals(1, listFollowersByUser.get(0).getUserIdToFollow()),
                () -> assertEquals(3, listFollowersByUser.get(1).getUserIdToFollow())
        );

    }


    @Test
    @DisplayName("Test Delete Follower.")
    void deleteFollowerTest() {
        //Arrange
        Follower pedro_Juan = Data.FOLLOWER_PEDRO_JUAN;
        Follower pedro_Felipe = Data.FOLLOWER_PEDRO_FELIPE;

        followerRepositoryImpl.createFollower(pedro_Juan);
        followerRepositoryImpl.createFollower(pedro_Felipe);

        //Act
        followerRepositoryImpl.deleteFollower(pedro_Juan);
        List<Follower> listFollowers = followerRepositoryImpl.getListAllFollowers();

        //Assert
        assertAll(
                () -> assertNotNull(listFollowers),
                () -> assertEquals(1, listFollowers.size()),
                () -> assertEquals(2, listFollowers.get(0).getUserId()),
                () -> assertEquals(3, listFollowers.get(0).getUserIdToFollow())
        );


    }
}