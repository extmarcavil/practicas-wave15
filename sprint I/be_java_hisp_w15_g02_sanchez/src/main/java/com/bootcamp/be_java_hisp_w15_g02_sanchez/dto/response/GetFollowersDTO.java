package com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetFollowersDTO {

    private int userId;
    private String userName;

    public GetFollowersDTO() {
    }
}
