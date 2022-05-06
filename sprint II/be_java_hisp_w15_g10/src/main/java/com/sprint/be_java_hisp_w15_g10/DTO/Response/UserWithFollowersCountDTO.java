package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UserWithFollowersCountDTO {
    private int user_id;
    private String user_name;
    private int followers_count;

    public UserWithFollowersCountDTO(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
