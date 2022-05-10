package com.sprint1.be_java_hisp_w15_g4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class IdNotPositiveErrorDTO {
    private HttpStatus status;
    private Map<String, String> errors;
}
