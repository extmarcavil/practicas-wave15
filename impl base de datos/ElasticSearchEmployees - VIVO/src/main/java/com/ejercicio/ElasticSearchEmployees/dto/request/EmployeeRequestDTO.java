package com.ejercicio.ElasticSearchEmployees.dto.request;

import lombok.Data;

@Data
public class EmployeeRequestDTO {
    private String  name;
    private String  lastname;
    private Integer age;
    private String  city;
}
