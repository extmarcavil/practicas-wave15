package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class RecentlyPostPromoDTO {

    private final Integer user_id;
    private final String user_name;
    private final List<ResponsePostPromoDTO> posts;

    public static RecentlyPostPromoDTO from(Integer id, String  user_name, List<ResponsePostPromoDTO> posts) {
        return new RecentlyPostPromoDTO(id, user_name, posts);
    }
}
