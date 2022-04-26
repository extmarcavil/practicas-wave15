package sprint1.socialmeli.model;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.exceptions.InvalidFolllower;

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
        this.name = name;
        this.id = id;
        this.listOfFollowed = new ArrayList<>();
        this.listOfFollowers = new ArrayList<>();
    }

    public void follow(User followedUser) {
        if( followedUser.equals(this))
            throw new InvalidFolllower("El usuario puede seguirse a si mismo");
        if( this.listOfFollowed.contains(followedUser) )
            throw new InvalidFolllower("El usuario no puede seguir a alguien que ya sigue");
        this.listOfFollowed.add(followedUser);
        followedUser.addTolistOfFollowers(this);
    }

    public void unfollow(User followedUser) {
        if( followedUser.equals(this))
            throw new InvalidFolllower("El usuario no puede dejar de seguirse a si mismo");
        if( this.listOfFollowed.contains(followedUser) == false)
            throw new InvalidFolllower("El usuario no puede dejar de seguir a alguien que no sigue");

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
