package sprint2.socialmeli.repository;

import sprint2.socialmeli.model.User;

public interface ISocialMeliRepository {
    User findUserById(Integer userID);
    boolean existUser(Integer userID);
}
