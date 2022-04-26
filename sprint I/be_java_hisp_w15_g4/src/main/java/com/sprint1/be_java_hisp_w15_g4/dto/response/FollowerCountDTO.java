package com.sprint1.be_java_hisp_w15_g4.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowerCountDTO {
     private int user_id;
     private String user_name;
     private int followers_count;
}
