package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer userID;
    private String name;
}
