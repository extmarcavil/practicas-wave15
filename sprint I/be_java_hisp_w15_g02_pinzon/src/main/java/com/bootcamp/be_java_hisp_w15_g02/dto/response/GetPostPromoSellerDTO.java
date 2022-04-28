package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetPostPromoSellerDTO {
    private int userId;
    private String userName;
    private List<PostPromoBySellerDTO> posts;

    public GetPostPromoSellerDTO() {
    }

    public GetPostPromoSellerDTO(int userId, String userName, List<PostPromoBySellerDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }
}
