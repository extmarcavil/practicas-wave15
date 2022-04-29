package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersWithFollowersDTO implements DTOEntity {
    private int user_id;
    private String user_name;
    private List<UserDTO> followers;
}
