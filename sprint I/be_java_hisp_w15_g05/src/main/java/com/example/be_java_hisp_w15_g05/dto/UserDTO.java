package com.example.be_java_hisp_w15_g05.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private int userId;
    private String userName;

    public UserDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
