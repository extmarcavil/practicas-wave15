package com.elastic.crud.dto.request;

import lombok.Data;

@Data
public class EmployeeRequestDTO {

    private String id;
    private String name;
    private String lastname;
    private Integer age;
    private String city;
}
