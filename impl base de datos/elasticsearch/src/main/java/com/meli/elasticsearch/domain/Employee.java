package com.meli.elasticsearch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.elasticsearch.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Employee implements ElasticDocument {

    public static final String INDEX = "employee";

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Text)
    private String state;

    @JsonProperty("postal_code")
    @Field(name = "postal_code", type = FieldType.Integer)
    private Integer postalCode;

    public Employee updateFrom(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName() == null ? this.name : employeeDto.getName(),
                employeeDto.getAge() == null ? this.age : employeeDto.getAge(),
                employeeDto.getState() == null ? this.state : employeeDto.getState(),
                employeeDto.getPostalCode() == null ? this.postalCode : employeeDto.getPostalCode()
        );
    }

    public static Employee forSave(EmployeeDto employeeDto) {
        return new Employee(
                null,
                employeeDto.getName(),
                employeeDto.getAge(),
                employeeDto.getState(),
                employeeDto.getPostalCode()
        );
    }

}
