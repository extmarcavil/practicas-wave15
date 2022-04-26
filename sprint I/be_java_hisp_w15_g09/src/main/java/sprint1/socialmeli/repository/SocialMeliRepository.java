package sprint1.socialmeli.repository;

import org.springframework.stereotype.Repository;
import sprint1.socialmeli.model.User;

import java.util.HashMap;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {

    HashMap <Integer, User> userDB;

    public SocialMeliRepository() {
        this.userDB = new HashMap<>();
    }
}
