package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    ArrayList<User> users = new ArrayList<>();

    public UserRepository(){
        ArrayList<Integer> galperinSeguidores = new ArrayList<>();
        ArrayList<Integer> galperinSeguidos = new ArrayList<>();
        galperinSeguidores.add(10);

        User galperin = new User(1,"Marcos Galperin",true,galperinSeguidos,galperinSeguidores);
        User juan = new User(10,"Juan",false,null,null);

        users.add(galperin);
        users.add(juan);
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
        return 0;
    }

    @Override
    public List<User> followersList(int id) {
        return null;
    }
}
