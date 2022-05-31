package com.spring.ejercicioempleadoselasticsearch.dto.request;

import lombok.Data;

@Data
public class EmployeeRequestDTO {
    private String name;
    private String lastname;
    private Integer edad;
    private String ciudad;
    private String provincia;
}
