package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostListDTO {
    private Integer user_id;
    private List<PostNotUserIdDTO> posts;
}
