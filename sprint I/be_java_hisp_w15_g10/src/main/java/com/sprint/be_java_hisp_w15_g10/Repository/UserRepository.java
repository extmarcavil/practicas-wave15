package com.sprint.be_java_hisp_w15_g10.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> usuarios;

    public UserRepository(){
        usuarios = new ArrayList<User>();

        User user1 = new User(1, "Alejandro");
        User user2 = new User(2, "Camilo");
        User user3 = new User(3, "Luis");

        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        user1.agregarSeguidor(user3);
        user1.seguirUsuario(user2);

        user2.agregarSeguidor(user1);

        user3.seguirUsuario(user1);

    }
}
