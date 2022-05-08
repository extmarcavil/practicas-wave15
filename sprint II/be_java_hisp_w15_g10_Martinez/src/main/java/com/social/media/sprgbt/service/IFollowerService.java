package com.social.media.sprgbt.service;

import com.social.media.sprgbt.dto.FollowerDto;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;

import java.util.List;

public interface IFollowerService {

    /**
     * Create Follower
     *
     * @param followerDto param
     * @return {@link FollowerDto} obj
     * @throws ExistingException exception
     */
    FollowerDto createFollower(FollowerDto followerDto) throws ExistingException;

    /**
     * Get Count Followers By Seller.
     *
     * @param userIdToFollow param
     * @return Integer obj
     */
    Integer getCountFollowersBySeller(Integer userIdToFollow);

    /**
     * Get All Followers By Seller.
     *
     * @param userIdToFollow param
     * @return {@link FollowerDto} list
     */
    List<FollowerDto> getAllFollowersBySeller(Integer userIdToFollow);

    /**
     * Get All Followed By User.
     *
     * @param userId param
     * @return {@link FollowerDto} list
     */
    List<FollowerDto> getListFollowedByUser(Integer userId);

    /**
     * Unfollow A Seller
     *
     * @param userId         param
     * @param userIdToFollow param
     * @return {@link FollowerDto} obj
     * @throws NotFoundException exception
     */
    FollowerDto unfollowASeller(Integer userId, Integer userIdToFollow) throws NotFoundException;

}
