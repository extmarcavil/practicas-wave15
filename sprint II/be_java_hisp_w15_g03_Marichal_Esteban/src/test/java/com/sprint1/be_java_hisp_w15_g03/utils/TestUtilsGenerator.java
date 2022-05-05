package com.sprint1.be_java_hisp_w15_g03.utils;

import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.RepoData;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtilsGenerator {

    public static RepoData dataToTest(){
        // Creacion de usuarios
        User user1 = new User(50, "Edgar");
        User user2 = new User(51, "Jaquelina");
        User user3 = new User(52, "Belen");
        User user4 = new User(53, "Facundo");
        User user5 = new User(54, "Valentina");
        User user6 = new User(55, "Esteban");

        // Creacion de vendedores
        Seller seller1 = new Seller(50, "Netflix");
        Seller seller2 = new Seller(51, "Movistar");
        Seller seller3 = new Seller(52, "Claro");
        Seller seller4 = new Seller(53, "Antel");
        Seller seller5 = new Seller(54, "HBO");
        Seller seller6 = new Seller(55, "Disney");


        // Relaciones entre usuarios y vendedores

        // Edgar sigue a Netflix y HBO
        user1.getFollowed().add(seller1);
        seller1.getFollowers().add(user1);
        user1.getFollowed().add(seller5);
        seller5.getFollowers().add(user1);

        // Jaquelina sigue a Disney
        // (esta relación se crea para poder dejar de seguir a un vendedor)
        user2.getFollowed().add(seller6);
        seller6.getFollowers().add(user2);

        List<Publication> publications = new ArrayList<>();

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        List<Seller> sellers = Arrays.asList(seller1, seller2, seller3, seller4, seller5, seller6);


        return new RepoData(users, sellers, publications);
    }

}
