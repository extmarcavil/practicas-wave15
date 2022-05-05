package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersListDTO {
    private Integer user_id;
    private String user_name;
    private List<UserDTO> followers;
}
