package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FollowersListDTO {
    private Integer user_id;
    private String user_name;
    private List<UserDTO> followers;
}
