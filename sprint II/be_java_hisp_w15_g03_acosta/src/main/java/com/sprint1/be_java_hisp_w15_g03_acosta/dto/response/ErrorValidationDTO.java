package com.sprint1.be_java_hisp_w15_g03_acosta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorValidationDTO {
    private String message;
    private HashMap<String, List<String>> errors;
}
