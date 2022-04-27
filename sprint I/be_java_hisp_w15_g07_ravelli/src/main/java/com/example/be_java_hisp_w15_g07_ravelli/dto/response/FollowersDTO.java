package com.example.be_java_hisp_w15_g07_ravelli.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowersDTO {
    private Integer userID;
    private String userName;
    private List<UserFollowersDTO> followers;
}
