package com.bootcamp.be_java_hisp_w15_g08.util;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.DetailDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;

import java.time.LocalDate;

public class Utils2 {

    public static NewPostDTO newPostDTO1(){
        DetailDTO postDetail1 = new DetailDTO(1,"Gallinas","Farmer","Criolla","Yellow and Orange","Gallina ponedora");
        NewPostDTO newPostDTO = new NewPostDTO(1,1234,LocalDate.now(),postDetail1,100,20000);
        return newPostDTO;
    }

    public static FollowersCountDTO followersCountDTO1(){
        return new FollowersCountDTO(1234,"Cosme Fulanito",2);
    }

    /*
        User user1 = new User(1234, "Cosme Fulanito");
        User user2 = new User(1235, "Max Power");
        User user3 = new User(1236, "Homer Thompson");
        User user4 = new User(1237, "Mister Json");
     */


}
