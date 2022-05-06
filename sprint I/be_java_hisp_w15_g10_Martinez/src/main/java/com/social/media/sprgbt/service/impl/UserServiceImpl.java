package com.social.media.sprgbt.service.impl;

import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.entity.User;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.UserMapper;
import com.social.media.sprgbt.repository.IUserRepository;
import com.social.media.sprgbt.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    /**
     * Instancia del User Repository
     */
    private final IUserRepository userRepository;

    /**
     * Instancia User Mapper.
     */
    private final UserMapper userMapper;


    /**
     * Dependency injection
     *
     * @param userRepository instance
     * @param userMapper     instance
     */
    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Create User
     *
     * @param dto param
     * @return {@link UserDto} obj
     * @throws ExistingException exception
     */
    @Override
    public UserDto createUser(UserDto dto) throws ExistingException {

        if (userRepository.getUserByUsername(dto.getUserName()) != null) {
            throw new ExistingException(String.format("El Usuario con userName: %s ya existe en la BD.", dto.getUserName()));
        }

        User user = userRepository.createUser(userMapper.mapToEntity(dto));

        log.info("User: {}", user);

        return userMapper.mapToDto(user);
    }

    /**
     * Get All Users
     *
     * @return {@link UserDto} list
     */
    public List<UserDto> getAllUsers() {

        List<UserDto> listUserDto = userRepository.getAllUsers().stream()
                .map(u -> userMapper.mapToDto(u))
                .collect(Collectors.toList());

        return listUserDto;
    }

    /**
     * Get User By Username
     *
     * @param userName param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public UserDto getUserByUsername(String userName) throws NotFoundException {

        User user = userRepository.getUserByUsername(userName);

        if (user == null) {
            throw new NotFoundException(String.format("El Usuario con userName: %s no existe en la BD.", userName));
        }

        log.info("User: {}", user);

        return userMapper.mapToDto(user);
    }

    /**
     * Check User Given Id.
     *
     * @param id param
     * @return {@link UserDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public UserDto getUserById(Integer id) throws NotFoundException {

        User user = userRepository.getUserById(id);

        if (user == null) {
            throw new NotFoundException(String.format("El Usuario con userId: %s no existe en la BD.", id));
        }

        return userMapper.mapToDto(user);
    }

}
