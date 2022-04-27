package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UsersWithFollowersDTO {
    private int user_id;
    private String user_name;
    private List<UserDTO> followers;
}
