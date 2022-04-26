package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowersResponseDTO {
    private int user_id;
    private String user_name;

    public FollowersResponseDTO() {
    }
}
