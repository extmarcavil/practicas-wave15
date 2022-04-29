package com.sprint.be_java_hisp_w15_g10.DTO.Response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithFollowedUsersDTO implements DTOEntity {
    @JsonProperty("user_id")
    private int user_id;
    @JsonProperty("user_name")
    private String user_name;
    @JsonProperty("followed")
    private List<UserDTO> followed;
}
