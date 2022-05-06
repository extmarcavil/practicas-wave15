package com.sprint2.be_java_hisp_w15_g4.repository;

import com.sprint2.be_java_hisp_w15_g4.model.User;

public interface IUserRepository {
    User findUser(int id);
}
