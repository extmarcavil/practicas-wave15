package com.bootcamp.be_java_hisp_w15_g02.repository;

import com.bootcamp.be_java_hisp_w15_g02.model.*;

import java.util.List;

public interface IUserRepository {
    List<User> getListUser();
    User getUserById(int userId);
    boolean follow(int userId, int userToFollow);
    boolean unFollow(int userId, int userIdToUnFollow);

}
