package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersWithFollowersDTO {
    private int user_id;
    private String user_name;
    private List<UserDTO> followers;
}
