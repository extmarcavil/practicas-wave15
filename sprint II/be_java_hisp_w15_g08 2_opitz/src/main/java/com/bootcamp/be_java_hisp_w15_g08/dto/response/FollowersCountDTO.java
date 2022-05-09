package com.bootcamp.be_java_hisp_w15_g08.dto.response;


import lombok.*;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class FollowersCountDTO {
    private int user_id;
    private  String user_name;
    private  int followers_count;
}
