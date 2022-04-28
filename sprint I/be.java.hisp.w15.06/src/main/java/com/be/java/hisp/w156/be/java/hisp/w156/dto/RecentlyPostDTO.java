package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class RecentlyPostDTO {


    private final Integer user_id;
    private final List<ResponsePostDTO> posts;

    public static RecentlyPostDTO from(Integer id, List<ResponsePostDTO> posts) {
        return new RecentlyPostDTO(id, posts);
    }
}
