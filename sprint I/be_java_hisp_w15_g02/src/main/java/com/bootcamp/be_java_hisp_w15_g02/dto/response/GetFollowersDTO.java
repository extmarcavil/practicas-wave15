package com.bootcamp.be_java_hisp_w15_g02.dto.response;

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
