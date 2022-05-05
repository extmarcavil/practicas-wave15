package sprint2.socialmeli.utils;

import sprint2.socialmeli.model.User;

public class UserFactory {

    static int idCounter = 0;

    static public User createAnUser(){
        return new User(idCounter++,"DummyName");
    }
    static public User createAnUserWithName(String name){
        return new User(idCounter++,name);
    }
}
