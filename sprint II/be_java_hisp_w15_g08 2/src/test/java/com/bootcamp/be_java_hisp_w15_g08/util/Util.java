package com.bootcamp.be_java_hisp_w15_g08.util;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.DetailDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.Post;
import com.bootcamp.be_java_hisp_w15_g08.model.PostDetail;
import com.bootcamp.be_java_hisp_w15_g08.model.User;

import java.time.LocalDate;
import java.util.*;


public class Util {

//    public Map<Integer,UserDTO> listUsers (){
//        Map<Integer,UserDTO> users = new HashMap<>();
//        UserDTO user1 = new UserDTO(1234,"Cosme Fulanito");
//        UserDTO user2 = new UserDTO(1235,"Max Power");
//        UserDTO user3 = new UserDTO(1236,"Homer Thompson");
//        UserDTO user4 = new UserDTO(1237,"Mister Json");
//
//        users.put(user1.getUserID(),user1);
//        users.put(user2.getUserID(),user2);
//        users.put(user3.getUserID(),user3);
//        users.put(user4.getUserID(),user4);
//        return users;
    //Por si las moscas si no se usa se borra al final.
//    }

    public static User user3(){
        User user1 = new User(1235,"Max Power");
        PostDetail postDetail1 = new PostDetail(1,"Gallinas","Farmer","Criolla","Yellow and Orange","Gallina ponedora");
        PostDetail postDetail2 = new PostDetail(2,"Silla","Gamer","Racer","Red and Blac","Special Edition");
        PostDetail postDetail3 = new PostDetail(3,"Mouse","Office","HP","Bluel","Optical");
        PostDetail postDetail4 = new PostDetail(4,"Teclado","Office","Acer","Black","Mechanic");
        PostDetail postDetail5 = new PostDetail(5,"Monitor","Office","Asus","Red","LCD");

        Post post1 = new Post(1, LocalDate.of(2022,5,1),postDetail1,10,10000);
        Post post2 = new Post(2, LocalDate.of(2022,5,4),postDetail2,11,15000);
        Post post3 = new Post(3, LocalDate.of(2022,5,2),postDetail3,12,20000);
        Post post4 = new Post(4, LocalDate.of(2020,3,25),postDetail4,13,25000);
        Post post5 = new Post(5, LocalDate.of(2019,2,8),postDetail5,14,30000);

        Map<Integer,Post> post = new HashMap<>();
        post.put(1,post1);
        post.put(2,post2);
        post.put(3,post3);
        post.put(4,post4);
        post.put(5,post5);

        user1.setPosts(post);
        return user1;
    }

    public static PostListDTO listaDePostOrdenadaYFiltradaAsc(){
        DetailDTO postDetail1 = new DetailDTO(1,"Gallinas","Farmer","Criolla","Yellow and Orange","Gallina ponedora");
        DetailDTO postDetail2 = new DetailDTO(2,"Silla","Gamer","Racer","Red and Blac","Special Edition");
        DetailDTO postDetail3 = new DetailDTO(3,"Mouse","Office","HP","Bluel","Optical");

        PostNotUserIdDTO post1 = new PostNotUserIdDTO(1, LocalDate.of(2022,5,1),postDetail1,10,10000);
        PostNotUserIdDTO post3 = new PostNotUserIdDTO(3, LocalDate.of(2022,5,2),postDetail3,12,20000);
        PostNotUserIdDTO post2 = new PostNotUserIdDTO(2, LocalDate.of(2022,5,4),postDetail2,11,15000);

        List<PostNotUserIdDTO> lista = Arrays.asList(post1,post3,post2);
        PostListDTO postListDTO = new PostListDTO(1234,lista);

        return postListDTO;
    }

    public static PostListDTO listaDePostOrdenadaYFiltradaDesc(){
        DetailDTO postDetail1 = new DetailDTO(1,"Gallinas","Farmer","Criolla","Yellow and Orange","Gallina ponedora");
        DetailDTO postDetail2 = new DetailDTO(2,"Silla","Gamer","Racer","Red and Blac","Special Edition");
        DetailDTO postDetail3 = new DetailDTO(3,"Mouse","Office","HP","Bluel","Optical");

        PostNotUserIdDTO post1 = new PostNotUserIdDTO(1, LocalDate.of(2022,5,1),postDetail1,10,10000);
        PostNotUserIdDTO post3 = new PostNotUserIdDTO(3, LocalDate.of(2022,5,2),postDetail3,12,20000);
        PostNotUserIdDTO post2 = new PostNotUserIdDTO(2, LocalDate.of(2022,5,4),postDetail2,11,15000);

        List<PostNotUserIdDTO> lista = Arrays.asList(post2,post3,post1);
        PostListDTO postListDTO = new PostListDTO(1234,lista);

        return postListDTO;
    }

    public static User user1(){
        User user1 = new User(1234,"Cosme Fulanito");
        List<User> list = Arrays.asList(
                new User(1235,"Max Power")
                ,new User(1236,"Homer Thompson")
                ,new User(1237,"Mister Json")
        );
        List<User> list2 = Arrays.asList(user3());//Aqui vamos a meter el de los post.
        user1.setFollowers(list);
        user1.setFollowing(list2);
        return user1;
    }


    public static FollowersListDTO asc_List(){
        FollowersListDTO ascList = new FollowersListDTO();
        ascList.setUser_id(1234);
        ascList.setUser_name("Cosme Fulanito");
        List<UserDTO> asc = Arrays.asList(
                new UserDTO(1236,"Homer Thompson")
                ,new UserDTO(1235,"Max Power")
                ,new UserDTO(1237,"Mister Json")
        );
        ascList.setFollowers(asc);
        return ascList;
    }

    public static FollowersListDTO desc_List(){
        FollowersListDTO descList = new FollowersListDTO();
        descList.setUser_id(1234);
        descList.setUser_name("Cosme Fulanito");
        List<UserDTO> desc = Arrays.asList(
                new UserDTO(1237,"Mister Json")
                ,new UserDTO(1235,"Max Power")
                ,new UserDTO(1236,"Homer Thompson")
        );
        descList.setFollowers(desc);
        return descList;
    }




}
