package com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GetProductsPromoByUserDTO {
    private int user_id;
    private String user_name;
    private List<PostDTO> posts;



    public GetProductsPromoByUserDTO() {
    }

    public GetProductsPromoByUserDTO(int user_id, String user_name, List<PostDTO> posts) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.posts = posts;
    }
}
