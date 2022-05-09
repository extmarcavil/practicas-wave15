package com.sprint1.be_java_hisp_w15_g03_acosta.util;

import com.sprint1.be_java_hisp_w15_g03_acosta.model.Seller;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Inicio de datos para Test de Integración
 */

public class PersonFactor {

    public static List<User> users(){
        User user1 = new User(3, "Maria");
        User user2 = new User(4, "Juan");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }

    public static List<Seller> sellers(){
        Seller seller1 = new Seller(3, "Garbarino");
        Seller seller2 = new Seller(4, "Musimundo");
        List<Seller> sellers = new ArrayList<>();
        sellers.add(seller1);
        sellers.add(seller2);
        return sellers;
    }
}
