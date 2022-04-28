package com.example.be_java_hisp_w15_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResCountFollowersDTO {
    private int user_id;
    private String user_name;
    private int followers_count;
}
