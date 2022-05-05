package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListDTO {
    private Integer user_id;
    private List<PostNotUserIdDTO> posts;
}
