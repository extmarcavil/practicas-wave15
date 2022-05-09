package com.bootcamp.be_java_hisp_w15_g08.util;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.DetailDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.*;
import com.bootcamp.be_java_hisp_w15_g08.model.Post;
import com.bootcamp.be_java_hisp_w15_g08.model.PostDetail;
import com.bootcamp.be_java_hisp_w15_g08.model.User;

import java.time.LocalDate;
import java.util.*;


public class Util {

    public static NewPostDTO newPost(){

        DetailDTO postDetail3 = new DetailDTO(3,"Mouse","Office","HP","Bluel","Optical");
        NewPostDTO newPostDTO1 = new NewPostDTO(1,1234,LocalDate.now().minusDays(3),postDetail3,300,75000);

        return newPostDTO1;
    }

    public static FollowersCountDTO followersCount(){
        return new FollowersCountDTO(1234,"Byron Mayers",2);
    }


    public static User user3(){
        User user1 = new User(1235,"Max Power");
        PostDetail postDetail1 = new PostDetail(1,"Gallinas","Farmer","Criolla","Yellow and Orange","Gallina ponedora");
        PostDetail postDetail2 = new PostDetail(2,"Silla","Gamer","Racer","Red and Blac","Special Edition");
        PostDetail postDetail3 = new PostDetail(3,"Mouse","Office","HP","Bluel","Optical");
        PostDetail postDetail4 = new PostDetail(4,"Teclado","Office","Acer","Black","Mechanic");
        PostDetail postDetail5 = new PostDetail(5,"Monitor","Office","Asus","Red","LCD");

        Post post1 = new Post(1, LocalDate.now().minusDays(4),postDetail1,10,10000);
        Post post2 = new Post(2, LocalDate.now().minusDays(1),postDetail2,11,15000);
        Post post3 = new Post(3, LocalDate.now().minusDays(3),postDetail3,12,20000);
        Post post4 = new Post(4, LocalDate.now().minusDays(400),postDetail4,13,25000);
        Post post5 = new Post(5, LocalDate.now().minusDays(500),postDetail5,14,30000);

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

        PostNotUserIdDTO post1 = new PostNotUserIdDTO(1, LocalDate.now().minusDays(4),postDetail1,10,10000);
        PostNotUserIdDTO post3 = new PostNotUserIdDTO(3, LocalDate.now().minusDays(3),postDetail3,12,20000);
        PostNotUserIdDTO post2 = new PostNotUserIdDTO(2, LocalDate.now().minusDays(1),postDetail2,11,15000);

        List<PostNotUserIdDTO> lista = Arrays.asList(post1,post3,post2);
        PostListDTO postListDTO = new PostListDTO(1234,lista);

        return postListDTO;
    }

    public static PostListDTO listaDePostOrdenadaYFiltradaDesc(){
        DetailDTO postDetail1 = new DetailDTO(1,"Gallinas","Farmer","Criolla","Yellow and Orange","Gallina ponedora");
        DetailDTO postDetail2 = new DetailDTO(2,"Silla","Gamer","Racer","Red and Blac","Special Edition");
        DetailDTO postDetail3 = new DetailDTO(3,"Mouse","Office","HP","Bluel","Optical");

        PostNotUserIdDTO post1 = new PostNotUserIdDTO(1, LocalDate.now().minusDays(4),postDetail1,10,10000);
        PostNotUserIdDTO post3 = new PostNotUserIdDTO(3, LocalDate.now().minusDays(3),postDetail3,12,20000);
        PostNotUserIdDTO post2 = new PostNotUserIdDTO(2, LocalDate.now().minusDays(1),postDetail2,11,15000);

        List<PostNotUserIdDTO> lista = Arrays.asList(post2,post3,post1);
        PostListDTO postListDTO = new PostListDTO(1234,lista);

        return postListDTO;
    }

    public static PostListDTO listaDePostFiltrada(){
        DetailDTO postDetail1 = new DetailDTO(1,"Gallinas","Farmer","Criolla","Yellow and Orange","Gallina ponedora");
        DetailDTO postDetail2 = new DetailDTO(2,"Silla","Gamer","Racer","Red and Blac","Special Edition");
        DetailDTO postDetail3 = new DetailDTO(3,"Mouse","Office","HP","Bluel","Optical");

        PostNotUserIdDTO post1 = new PostNotUserIdDTO(1, LocalDate.now().minusDays(4),postDetail1,10,10000);
        PostNotUserIdDTO post2 = new PostNotUserIdDTO(2, LocalDate.now().minusDays(1),postDetail2,11,15000);
        PostNotUserIdDTO post3 = new PostNotUserIdDTO(3, LocalDate.now().minusDays(3),postDetail3,12,20000);


        List<PostNotUserIdDTO> lista = Arrays.asList(post1,post2,post3);
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
