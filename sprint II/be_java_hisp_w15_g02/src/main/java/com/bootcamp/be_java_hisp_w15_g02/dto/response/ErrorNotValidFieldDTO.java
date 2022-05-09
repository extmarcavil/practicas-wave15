package com.bootcamp.be_java_hisp_w15_g02.dto.response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorNotValidFieldDTO extends ErrorDTO {
    private String field;

    public ErrorNotValidFieldDTO(String status, String message, String field) {
        super(status, message);
        this.field = field;
    }

    public ErrorNotValidFieldDTO(String field) {
        this.field = field;
    }
}
