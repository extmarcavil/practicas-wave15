package sprint1.socialmeli.repository;

import sprint1.socialmeli.model.User;

import java.util.HashMap;

public interface ISocialMeliRepository {
    User findUserById(Integer userID);
    boolean existUser(Integer userID);
    HashMap<Integer, User> getAllUsers();
}
