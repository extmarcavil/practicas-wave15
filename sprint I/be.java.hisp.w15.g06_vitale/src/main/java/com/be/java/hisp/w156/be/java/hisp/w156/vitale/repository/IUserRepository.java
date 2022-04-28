package com.be.java.hisp.w156.be.java.hisp.w156.vitale.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.vitale.model.User;

public interface IUserRepository {

    void initData();

    User getUser(Integer id);

    boolean existsById(Integer id);
}
