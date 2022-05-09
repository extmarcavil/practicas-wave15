package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class FollowersDTO {

    private int userId;
    private String userName;

    public FollowersDTO() {
    }

    public FollowersDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
