package com.sprint1.be_java_hisp_w15_g4.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int user_id;
    private String user_name;

    public UserDTO(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
