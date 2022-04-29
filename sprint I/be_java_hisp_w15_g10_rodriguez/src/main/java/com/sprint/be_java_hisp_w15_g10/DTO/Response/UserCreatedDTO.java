package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreatedDTO implements DTOEntity {
    private String message;
}
