package com.sprint1.be_java_hisp_w15_g03.utils;

import com.sprint1.be_java_hisp_w15_g03.model.*;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtilsGenerator {

    public static RepoData dataToTest(){
        // Creación de usuarios
        User user1 = new User(50, "Edgar");
        User user2 = new User(51, "Jaquelina");
        User user3 = new User(52, "Belen");
        User user4 = new User(53, "Facundo");
        User user5 = new User(54, "Valentina");
        User user6 = new User(55, "Esteban");

        // Creación de vendedores
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

        // Caso de publicaciones
        // Esteban sigue a Antel, Claro y Movistar
        user6.getFollowed().add(seller4);
        user6.getFollowed().add(seller2);
        user6.getFollowed().add(seller3);
        seller4.getFollowers().add(user6);
        seller3.getFollowers().add(user6);
        seller2.getFollowers().add(user6);


        // Creación de publicaciones
        Product product = new Product(50, "Mesa", "Madera", "MDF", "Azul", "le falta una pata");
        Publication publication1 = new Publication(50, LocalDate.now().minus(3, ChronoUnit.WEEKS), Category.MESA, 300D, product, false, 0D);
        Publication publication2 = new Publication(51, LocalDate.now().minus(1, ChronoUnit.WEEKS), Category.MESA, 300D, product, false, 0D);
        Publication publication3 = new Publication(52, LocalDate.now(), Category.MESA, 300D, product, false, 0D);
        Publication publication4 = new Publication(53, LocalDate.now().minus(3, ChronoUnit.DAYS), Category.MESA, 300D, product, false, 0D);
        Publication publication5 = new Publication(54, LocalDate.now().minus(2, ChronoUnit.DAYS), Category.MESA, 300D, product, false, 0D);
        Publication publication6 = new Publication(55, LocalDate.now().minus(5, ChronoUnit.WEEKS), Category.MESA, 300D, product, false, 0D);

        // Relación de vendedores con las publicaciones
        seller2.getPublications().add(publication1);
        seller2.getPublications().add(publication2);
        seller2.getPublications().add(publication3);

        seller3.getPublications().add(publication4);

        seller4.getPublications().add(publication5);
        seller4.getPublications().add(publication6);

        // Se cargan listas
        List<Publication> publications = Arrays.asList(publication1, publication2, publication3);
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        List<Seller> sellers = Arrays.asList(seller1, seller2, seller3, seller4, seller5, seller6);

        return new RepoData(users, sellers, publications);
    }

}
