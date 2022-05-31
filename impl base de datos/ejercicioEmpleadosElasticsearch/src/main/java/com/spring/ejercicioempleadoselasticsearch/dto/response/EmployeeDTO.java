package com.spring.ejercicioempleadoselasticsearch.dto.response;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private String lastname;
    private Integer edad;
    private String ciudad;
    private String provincia;
}
