package com.bootcamp.be_java_hisp_w15_g02.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {

    private int userId;

    public UserCreateDTO(){}

    public UserCreateDTO(int userId) {
        this.userId = userId;
    }
}
