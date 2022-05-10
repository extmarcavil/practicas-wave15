package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import com.sprint.be_java_hisp_w15_g10.Model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPostResponseDTO {
    private int user_id;
    private List<PostResponseDTO> posts;
}
