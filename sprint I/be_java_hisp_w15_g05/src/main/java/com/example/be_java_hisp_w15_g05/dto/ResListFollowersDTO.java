package com.example.be_java_hisp_w15_g05.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResListFollowersDTO {

    private int userId;
    private String userName;
    private List<UserDTO> followers;

    public ResListFollowersDTO(int userId, String userName, List<UserDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }
}
