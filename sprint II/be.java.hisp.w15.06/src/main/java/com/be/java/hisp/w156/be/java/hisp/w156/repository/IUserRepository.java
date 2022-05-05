package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

public interface IUserRepository {

    User getUser(Integer id);

    boolean existsById(Integer id);

    void save(User user);
}
