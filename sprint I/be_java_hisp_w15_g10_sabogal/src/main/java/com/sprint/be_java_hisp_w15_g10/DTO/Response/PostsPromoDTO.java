package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class PostsPromoDTO {
    private int user_id;
    private String user_name;
    private List<PostPromoDTO> posts;
}
