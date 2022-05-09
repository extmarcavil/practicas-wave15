package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.util.function.Function;

public interface IUserRepository {

    User getUser(Integer id);

    <T> T findByIdForUpdate(Integer id, Function<User, T> callback);

}
