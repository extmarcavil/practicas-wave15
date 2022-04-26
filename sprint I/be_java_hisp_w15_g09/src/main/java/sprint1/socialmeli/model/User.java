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

    public User(int id, String name) {
        this.name = name;
        this.id = id;
        this.listOfFollowed = new ArrayList<>();
        this.listOfFollowers = new ArrayList<>();
    }

    public void follow(User followedUser) {
        this.listOfFollowed.add(followedUser);
        followedUser.addTolistOfFollowers(this);
    }

    public void unfollow(User followedUser) {
        this.listOfFollowed.remove(followedUser);
        followedUser.removeFromListOfFollowers(this);
    }

    private void removeFromListOfFollowers(User user) {
        this.listOfFollowers.remove(user);
    }

    private void addTolistOfFollowers(User user) {
        this.listOfFollowers.add(user);
    }
}
