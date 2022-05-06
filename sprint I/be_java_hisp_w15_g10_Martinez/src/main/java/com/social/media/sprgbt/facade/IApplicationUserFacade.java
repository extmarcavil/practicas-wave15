package com.social.media.sprgbt.facade;

import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;

import java.util.List;

public interface IApplicationUserFacade {


    /**
     * Create User.
     *
     * @param dto param
     * @return {@link UserDto} obj
     * @throws ExistingException expection
     */
    UserDto createUser(UserDto dto) throws ExistingException;

    /**
     * Get All Users.
     *
     * @return {@link UserDto} list
     */
    List<UserDto> getAllUsers();

    /**
     * Get User By Username.
     *
     * @param username param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    UserDto getUserByUsername(String username) throws NotFoundException;

    /**
     * Follow A Seller.
     *
     * @param userId         param
     * @param userIdToFollow param
     * @return message
     * @throws NotFoundException exception
     * @throws ExistingException exception
     */
    String followASeller(Integer userId, Integer userIdToFollow) throws NotFoundException, ExistingException;

    /**
     * Get Count Followers By Seller.
     *
     * @param userIdToFollow param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    UserDto getCountFollowersBySeller(Integer userIdToFollow) throws NotFoundException;

    /**
     * Get List Followers By Seller.
     *
     * @param userIdToFollow param
     * @param order          param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    UserDto getAllFollowersBySeller(Integer userIdToFollow, String order) throws NotFoundException;

    /**
     * Get List Followed By User.
     *
     * @param userId param
     * @param order  param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    UserDto getListFollowedByUser(Integer userId, String order) throws NotFoundException;

    /**
     * Unfollow A Seller
     *
     * @param userId         param
     * @param userIdToFollow param
     * @return message
     * @throws NotFoundException exception
     */
    String unfollowASeller(Integer userId, Integer userIdToFollow) throws NotFoundException;

}
