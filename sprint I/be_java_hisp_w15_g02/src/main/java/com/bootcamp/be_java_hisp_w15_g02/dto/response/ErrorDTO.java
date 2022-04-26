package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private boolean status;
    private String message;

    public ErrorDTO() {
    }
}
