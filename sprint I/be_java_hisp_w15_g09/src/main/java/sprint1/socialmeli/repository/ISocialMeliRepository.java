package sprint1.socialmeli.repository;

import sprint1.socialmeli.model.User;

public interface ISocialMeliRepository {
    User getUserByID(Integer userID);
    boolean existUser(Integer userID);
}
