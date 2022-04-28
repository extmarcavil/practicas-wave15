package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class ListPromoPostDTO {
    private final Integer user_id;
    private final List<ResponsePromoPostDTO> posts;

    public static ListPromoPostDTO from(Integer id, List<ResponsePromoPostDTO> posts) {
        return new ListPromoPostDTO(id, posts);
    }
}
