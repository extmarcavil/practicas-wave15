package sprint1.socialmeli.repository;

import sprint1.socialmeli.model.User;

import java.util.List;

public interface ISocialMeliRepository {
    User findUserById(Integer userID);
    boolean existUser(Integer userID);

    Integer save(String name);

    public List<User> getUsers();
}
