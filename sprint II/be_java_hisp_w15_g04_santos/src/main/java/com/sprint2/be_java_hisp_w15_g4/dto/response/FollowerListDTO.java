package com.sprint2.be_java_hisp_w15_g4.dto.response;

import com.sprint2.be_java_hisp_w15_g4.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FollowerListDTO {
    private int user_id;
    private String user_name;
    private List<UserDTO> followers;
}
