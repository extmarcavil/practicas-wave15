package com.sprint.be_java_hisp_w15_g10.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    String name;
    String message;

    public ErrorDTO(String name, String message ) {
        this.name    = name;
        this.message = message;
    }
}
