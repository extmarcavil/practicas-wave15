package com.social.media.sprgbt.service;

import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;

import java.util.List;

public interface IUserService {

    /**
     * Create User.
     *
     * @param dto param
     * @return {@link UserDto} obj
     * @throws ExistingException exception
     */
    UserDto createUser(UserDto dto) throws ExistingException;

    /**
     * Get All Users
     *
     * @return {@link UserDto} list
     */
    List<UserDto> getAllUsers();

    /**
     * Get User By Username
     *
     * @param userName param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    UserDto getUserByUsername(String userName) throws NotFoundException;

    /**
     * Get User By Id.
     *
     * @param id param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    UserDto getUserById(Integer id) throws NotFoundException;

}
