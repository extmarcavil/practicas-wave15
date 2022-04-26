package sprint1.socialmeli.repository;

import org.springframework.stereotype.Repository;
import sprint1.socialmeli.model.User;

import java.util.Arrays;
import java.util.HashMap;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {

    HashMap <Integer, User> userDB;

    public SocialMeliRepository() {
        this.userDB = new HashMap<>();
        cargarUsuarios();
    }


    public void cargarUsuarios(){
        User user1 = new User(userDB.size()+1, "Lorena Maciel");
        userDB.put(user1.getId(), user1);
        User user2 = new User(userDB.size()+1, "Gonzalo Murias");
        userDB.put(user2.getId(), user2);
        User user3 = new User(userDB.size()+1, "Alan Gimenez");
        userDB.put(user3.getId(), user3);
        User user4 = new User(userDB.size()+1, "Ramiro Vera");
        userDB.put(user4.getId(), user4);
        User user5 = new User(userDB.size()+1, "Alejandro Henestroza");
        userDB.put(user5.getId(), user5);
        User user6 = new User(userDB.size()+1, "Nicolas Kazandjian");
        userDB.put(user6.getId(), user6);

        user1.setListOfFollowers(Arrays.asList(user2, user3));
        user1.setListOfFollowed(Arrays.asList(user2, user3, user4, user5, user6));
    }

    @Override
    public User findUserById(Integer userID) {
        return userDB.get(userID);
    }
}
