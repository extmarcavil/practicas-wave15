package com.example.be_java_hisp_w15_g05.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResFollowPostDTO {

    private String message;

    public ResFollowPostDTO() {
    }

    public ResFollowPostDTO(String message) {
        this.message = message;
    }

}
