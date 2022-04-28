package sprint1.socialmeli.repository;

import sprint1.socialmeli.model.User;

public interface ISocialMeliRepository {
    User findUserById(Integer userID);
    boolean existUser(Integer userID);
}
