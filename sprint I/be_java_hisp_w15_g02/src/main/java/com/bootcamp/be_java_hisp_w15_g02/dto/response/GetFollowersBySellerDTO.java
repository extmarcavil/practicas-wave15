package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.GetFollowersDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFollowersBySellerDTO {
    private int user_id;
    private String user_name;
    private List<GetFollowersDTO> followers;

    public GetFollowersBySellerDTO() {
    }

    public GetFollowersBySellerDTO(int user_id, String user_name, List<GetFollowersDTO> followers) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = followers;
    }
}
