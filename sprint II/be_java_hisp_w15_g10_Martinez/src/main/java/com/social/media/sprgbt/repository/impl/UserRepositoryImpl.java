package com.social.media.sprgbt.repository.impl;

import com.social.media.sprgbt.entity.User;
import com.social.media.sprgbt.repository.IUserRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Repository
public class UserRepositoryImpl implements IUserRepository {

    public static AtomicInteger count = new AtomicInteger(0);

    /**
     * Lista de Usuarios.
     */
    public static List<User> listUsers;


    /**
     * Constudtor por Default.
     */
    public UserRepositoryImpl() {
        this.listUsers = new ArrayList<>();
    }

    /**
     * Create User
     *
     * @param user
     * @return {@link User} obj
     */
    @Override
    public User createUser(User user) {

        user.setUserId(count.incrementAndGet());
        log.info("User: {}", user);

        listUsers.add(user);

        return user;
    }

    /**
     * Get All Users
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return listUsers;
    }

    /**
     * Get User By Username
     *
     * @param userName
     * @return {@link User} obj
     */
    @Override
    public User getUserByUsername(String userName) {

        Optional<User> userOpt = listUsers.stream()
                .filter(u -> u.getUserName().equals(userName))
                .findFirst();

        return userOpt.orElse(null);
    }

    /**
     * Get User By Id
     *
     * @param userId
     * @return {@link User} obj
     */
    @Override
    public User getUserById(Integer userId) {

        Optional<User> userOpt = listUsers.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst();

        return userOpt.orElse(null);
    }

}
