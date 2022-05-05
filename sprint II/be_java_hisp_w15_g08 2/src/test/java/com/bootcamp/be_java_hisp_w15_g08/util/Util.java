package com.bootcamp.be_java_hisp_w15_g08.util;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public static User user1(){
        User user1 = new User(1234,"Cosme Fulanito");
        List<User> list = Arrays.asList(
                new User(1235,"Max Power")
                ,new User(1236,"Homer Thompson")
                ,new User(1237,"Mister Json")
        );
        user1.setFollowers(list);
        return user1;
    }

    public static User user2(){
        User user2 = new User(1234,"Fulano Opitz");
        List<User> list = Arrays.asList(
                new User(1235,"Klaus Pacheco")
                ,new User(1236,"Homer Thompson")
                ,new User(1237,"Mister Json")
                ,new User(1237,"Pacheco Json")
        );
        user2.setFollowers(list);
        return user2;
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
