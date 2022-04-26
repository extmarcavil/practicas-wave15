package sprint1.socialmeli.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    Integer id;
    String name;
    List<User> listOfFollowers;
    List<User> listOfFollowed;
    //...List<>

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.listOfFollowers = new ArrayList<>();
        this.listOfFollowed = new ArrayList<>();
    }
}
