package sprint2.socialmeli.repository;

import org.springframework.stereotype.Repository;
import sprint2.socialmeli.model.User;

import java.util.HashMap;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {

    HashMap <Integer, User> userDB;

    public SocialMeliRepository() {

        this.userDB = new HashMap<>();
        this.cargarUsuarios();
    }


    private void cargarUsuarios(){
        User user1 = new User(1, "Lorena Maciel");
        User user2 = new User(2, "Gonzalo Murias");
        User user3 = new User(3, "Alan Gimenez");
        User user4 = new User(4, "Ramiro Vera");
        User user5 = new User(5, "Alejandro Henestroza");
        User user6 = new User(6, "Nicolas Kazandjian");
        user2.follow(user4);
        user2.follow(user6);
        user2.follow(user3);
        user4.follow(user3);
        userDB.put(user1.getId(), user1);
        userDB.put(user2.getId(), user2);
        userDB.put(user3.getId(), user3);
        userDB.put(user4.getId(), user4);
        userDB.put(user5.getId(), user5);
        userDB.put(user6.getId(), user6);
    }

    @Override
    public User findUserById(Integer userID) {
        return userDB.get(userID);
    }

    @Override
    public boolean existUser(Integer userID) {
        return userDB.containsKey(userID);
    }
}
