package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    ArrayList<User> users = new ArrayList<>();

    public UserRepository() {
        User galperin = new User(1, "Marcos Galperin", true);
        User juan = new User(10, "Juan", false);
        User pedro = new User(11, "Pedro", false);
        User valentina = new User(12, "Valentina", false);

        galperin.agregarSeguidor(juan);
        juan.seguir(galperin);

        galperin.agregarSeguidor(pedro);
        pedro.seguir(galperin);

        users.add(galperin);
        users.add(juan);
        users.add(pedro);
        users.add(valentina);
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst();
    }

    @Override
    public boolean follow(User usuario, User vendedor) {
        if(vendedor.isSeller()){
            vendedor.agregarSeguidor(usuario);
            usuario.seguir(vendedor);
            return true;
        }
        return false;
    }

    @Override
    public int cantFollowers(User user) {
        return user.getSeguidores().size();
    }

    @Override
    public Optional<User> followersList(int id) {
        return findById(id);
    }

    @Override
    public Optional<User> sellersList(int id) {
        return findById(id);
    }
}
