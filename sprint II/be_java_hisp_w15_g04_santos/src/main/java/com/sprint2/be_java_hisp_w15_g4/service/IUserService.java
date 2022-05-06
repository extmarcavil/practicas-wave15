package com.sprint2.be_java_hisp_w15_g4.service;

import com.sprint2.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint2.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint2.be_java_hisp_w15_g4.dto.response.FollowingListDTO;

public interface IUserService {
    void follow(int userID, int userIDToFollow); //Req 01
    FollowerCountDTO countFollowers(int userID); //Req 02: devuelve la cantidad de usuarios que siguen a un vendedor dentro de un dto
    FollowerListDTO listFollowers(int userID,String order); //Req 03: devuelve la lista de usuarios que siguen a un determinado usuario
    FollowingListDTO listFollowing(int userID, String order); //Req 04: devuelve la lista de usuarios a quien sigue un determinado usuario
    void unfollow(int userID, int userIDToUnfollow); //Req 07
}
