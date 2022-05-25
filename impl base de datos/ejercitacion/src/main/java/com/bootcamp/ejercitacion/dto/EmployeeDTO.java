package com.bootcamp.ejercitacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String id;
    private String  name;
    private String  lastname;
    private Integer age;
    private String  city;
    private String states;

}
