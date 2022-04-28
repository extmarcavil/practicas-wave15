package com.sprint1.be_java_hisp_w15_g4.repository;

import com.sprint1.be_java_hisp_w15_g4.model.User;

public interface IUserRepository {
    User findUser(int id);
}
