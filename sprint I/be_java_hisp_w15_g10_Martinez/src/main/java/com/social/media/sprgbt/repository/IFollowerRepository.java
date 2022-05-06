package com.social.media.sprgbt.repository;

import com.social.media.sprgbt.entity.Follower;

import java.util.List;

public interface IFollowerRepository {

    /**
     * Create Follower
     *
     * @param follower
     * @return {@link Follower} obj
     */
    Follower createFollower(Follower follower);

    /**
     * Get Follower By UserId And UserIdToFollow
     *
     * @param userId
     * @param userIdToFollow
     * @return {@link Follower} obj
     */
    Follower getFollowerByUserIdAndUserIdToFollow(Integer userId, Integer userIdToFollow);

    /**
     * Get List All Followers.
     *
     * @return
     */
    List<Follower> getListAllFollowers();

    /**
     * Get List Followers By Seller.
     *
     * @param userIdToFollow
     * @return
     */
    List<Follower> getListFollowersBySeller(Integer userIdToFollow);

    /**
     * Get List Followed By User.
     *
     * @param userId
     * @return
     */
    List<Follower> getListFollowedByUser(Integer userId);

    /**
     * Delete Follower.
     * @param follower
     */
    void deleteFollower(Follower follower);


}
