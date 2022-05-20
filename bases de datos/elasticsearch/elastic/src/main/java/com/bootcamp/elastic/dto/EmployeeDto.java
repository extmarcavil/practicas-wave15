package com.bootcamp.elastic.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String departament;
}
