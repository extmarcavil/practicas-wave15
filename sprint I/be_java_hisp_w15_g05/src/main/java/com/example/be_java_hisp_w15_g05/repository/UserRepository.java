package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    ArrayList<User> users = new ArrayList<>();

    public UserRepository(){
        User galperin = new User(1,"Marcos Galperin",true);
        User juan = new User(10,"Juan",false);
        User pedro = new User(11, "Pedro",false);

        galperin.agregarSeguidor(10);
        juan.seguir(1);

        galperin.agregarSeguidor(11);
        pedro.seguir(1);

        users.add(galperin);
        users.add(juan);
        users.add(pedro);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean follow(int seguidor, int seguido) {
        return false;
    }

    @Override
    public int cantFollowers(int id) {
        User user = users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst()
                .orElse(null);

        if(user == null) return 0;

        return user.getSeguidores().size();
    }

    @Override
    public List<User> followersList(int id) {
        return null;
    }
}
