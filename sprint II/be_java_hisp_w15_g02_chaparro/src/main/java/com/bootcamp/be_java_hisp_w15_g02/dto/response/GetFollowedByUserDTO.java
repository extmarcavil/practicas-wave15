package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFollowedByUserDTO {
    private int user_id;
    private String user_name;
    private List<GetFollowersDTO> followed;

    public GetFollowedByUserDTO() {
    }

    public GetFollowedByUserDTO(int user_id, String user_name, List<GetFollowersDTO> followers) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followed = followers;
    }
}

