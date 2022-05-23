package com.meli.elasticsearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.elasticsearch.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto implements ElasticDocumentDto {

    @Nullable
    private final String id;
    @Nullable
    private final String name;
    @Nullable
    private final Integer age;
    @Nullable
    private final String state;
    @Nullable
    private final Integer postalCode;

    public static EmployeeDto from(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getState(),
                employee.getPostalCode()
        );
    }
}
