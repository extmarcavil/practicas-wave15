package com.sprint1.be_java_hisp_w15_g03.utils;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataUtil {
    private final List<User> users;
    private final List<Seller> sellers;

    public DataUtil(){

        //Se asume que las direcciones a partir de la 5000 son reservadas para testing
        //Se modifica implementacion de addUser y addSeller por esto
        User user1 = new User(5000, "TestUser Primero");
        User user2 = new User (5001, "TestUser Segundo");
        User user3 = new User(5002, "TestUser Tercero");
        User user4 = new User (5003, "TestUser Cuarto");
        User user5 = new User(5004, "TestUser Quinto");
        User user6 = new User (5005, "TestUser Sexto");


        //Se asume que las direcciones a partir de la 5000 son reservadas para testing
        //Se modifica implementacion de addUser y addSeller por esto
        Seller seller1 = new Seller(5000,"AmazonTest");
        List<User> followers1 = new ArrayList<>();
        Collections.addAll(followers1,user1,user2,user4);
        seller1.setFollowers(followers1);
        Seller seller2 = new Seller(5001,"MeliTest");
        List<User> followers2 = new ArrayList<>();
        Collections.addAll(followers2, user1,user2,user3,user4,user6);
        seller2.setFollowers(followers2);
        Seller seller3 = new Seller(5002,"EbayTest");
        List<User> followers3 = new ArrayList<>();
        Collections.addAll(followers2, user1,user3,user6);
        seller3.setFollowers(followers3);
        Seller seller4 = new Seller(5003,"BestBuyTest");

        Seller seller5 = new Seller(5004,"AdidasTest");
        List<User> followers5 = new ArrayList<>();
        Collections.addAll(followers5, user6);
        seller5.setFollowers(followers5);

        sellers= new ArrayList<>();
        Collections.addAll(sellers,seller1,seller2,seller3,seller4,seller5);

        List<Seller> followed1 = new ArrayList<>();
        Collections.addAll(followed1,seller1,seller2,seller3);
        user1.setFollowed(followed1);
        List<Seller> followed2 = new ArrayList<>();
        Collections.addAll(followed2,seller1,seller2);
        user2.setFollowed(followed2);

        List<Seller> followed3 = new ArrayList<>();
        Collections.addAll(followed3,seller2,seller3);
        user3.setFollowed(followed3);

        List<Seller> followed4 = new ArrayList<>();
        Collections.addAll(followed4,seller1,seller2);
        user4.setFollowed(followed4);

        user5.setFollowed(new ArrayList<>());

        List<Seller> followed6 = new ArrayList<>();
        Collections.addAll(followed6,seller2,seller3,seller5);
        user6.setFollowed(followed6);



        users= new ArrayList<>();
        Collections.addAll(users,user1,user2,user3,user4,user5,user6);




    }
    public List<User> getUsers(){
        return users;
    }

    public List<Seller> getSellers(){
        return sellers;
    }
    public SellerFListDTO getFirstSellerFListDTO(String orden){
        Seller seller = sellers.get(0);
        SellerFListDTO resp = new SellerFListDTO();
        resp.setUserId(seller.getUserId());
        resp.setUserName(seller.getUserName());
        PersonDTO p1 = new PersonDTO(5000,"TestUser Primero");
        PersonDTO p2 = new PersonDTO(5001,"TestUser Segundo");
        PersonDTO p3 = new PersonDTO(5003,"TestUser Cuarto");
        List<PersonDTO> personas = new ArrayList<>();
        switch (orden){
            case "asc":
                Collections.addAll(personas,p3,p1,p2);
                break;
            case "desc":
                Collections.addAll(personas,p2,p1,p3);
                break;
            default:
                Collections.addAll(personas,p1,p2,p3);
                break;
        }
        resp.setFollowers(personas);

        return resp;

    }

    public UserListDTO getFirstUserListDTO(String orden){
        User user = users.get(0);
        UserListDTO resp = new UserListDTO();
        resp.setUserId(user.getUserId());
        resp.setUserName(user.getUserName());


        PersonDTO p1 = new PersonDTO(5000,"AmazonTest");
        PersonDTO p2 = new PersonDTO(5001,"MeliTest");
        PersonDTO p3 = new PersonDTO(5003,"EbayTest");
        List<PersonDTO> personas = new ArrayList<>();
        switch (orden){
            case "asc":
                Collections.addAll(personas,p1,p3,p2);
                break;
            case "desc":
                Collections.addAll(personas,p2,p3,p1);
                break;
            default:
                Collections.addAll(personas,p1,p2,p3);
                break;
        }
        resp.setFollowed(personas);

        return resp;

    }


}
