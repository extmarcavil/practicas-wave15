package com.car.concessionaire.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RequiredArgsConstructor()
@Getter
public class FieldErrorDto {

    private final String field;
    private final String message;

    public static FieldErrorDto from(MissingServletRequestParameterException ex) {
        return new FieldErrorDto(ex.getParameterName(), ex.getMessage());
    }

    public static FieldErrorDto from(MethodArgumentTypeMismatchException ex) {
        String message = String.format(ex.getMessage().split(";")[0]+". Valid format %s", "'yyyy-MM-dd'");
        return new FieldErrorDto(ex.getParameter().getParameterName(), message);
    }
}
