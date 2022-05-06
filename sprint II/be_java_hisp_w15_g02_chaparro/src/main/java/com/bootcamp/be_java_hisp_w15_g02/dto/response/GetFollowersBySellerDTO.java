package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class GetFollowersBySellerDTO {
    private int userId;
    private String userName;
    private List<GetFollowersDTO> followers;

    public GetFollowersBySellerDTO() {
    }

    public GetFollowersBySellerDTO(int userId, String userName, List<GetFollowersDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }
}
