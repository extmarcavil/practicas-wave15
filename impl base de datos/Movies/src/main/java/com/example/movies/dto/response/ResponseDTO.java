package com.example.movies.dto.response;

import lombok.Data;

@Data
public class ResponseDTO {

    private String statusCode;
    private Object body;
}