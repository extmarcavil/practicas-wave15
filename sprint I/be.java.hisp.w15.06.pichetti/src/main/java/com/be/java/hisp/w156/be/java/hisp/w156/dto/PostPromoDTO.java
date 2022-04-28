package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class PostPromoDTO {

    private final Integer user_id;
    private final List<ResponsePostPromoDTO> posts;

    public static PostPromoDTO from(Integer id, List<ResponsePostPromoDTO> posts) {
        return new PostPromoDTO(id, posts);
    }

}
