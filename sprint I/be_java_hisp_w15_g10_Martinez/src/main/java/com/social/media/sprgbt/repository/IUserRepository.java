package com.social.media.sprgbt.repository;

import com.social.media.sprgbt.entity.User;

import java.util.List;

public interface IUserRepository {

    /**
     * Create User
     *
     * @param user
     * @return {@link User} obj
     */
    User createUser(User user);

    /**
     * Get All Users
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     * Get User By Username
     *
     * @param userName
     * @return {@link User} obj
     */
    User getUserByUsername(String userName);

    /**
     * Get User By Id
     *
     * @param userId
     * @return {@link User} obj
     */
    User getUserById(Integer userId);

}
