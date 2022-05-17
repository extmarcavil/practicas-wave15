package com.example.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter  @Setter
public class ErrorDTO {
    private String title;
    private String message;
    private HashMap<String, List<String>> errors;
}
