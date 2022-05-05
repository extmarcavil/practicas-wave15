package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> users;
    public UserRepositoryImpl() {
        this.users = new ArrayList<>();

        User u1 = new User(1L, "Lukf");
        User u2 = new User(2L, "JLeon");
        User u3 = new User(3L, "GSinnott");
        User u4 = new User(4L, "AnaS");
        User u5 = new User(5L, "TRamirez");
        User u6 = new User(6L, "MBarraza");

        this.users.add(u1);
        this.users.add(u2);
        this.users.add(u3);
        this.users.add(u4);
        this.users.add(u5);
        this.users.add(u6);
    }

    @Override
    public Optional<User> findById(Long id) {
        return users
                .stream()
                .filter(u -> u.getUserId().equals(id))
                .findFirst();
    }


}
