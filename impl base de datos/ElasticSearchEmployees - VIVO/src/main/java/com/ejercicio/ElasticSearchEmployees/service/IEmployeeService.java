package com.ejercicio.ElasticSearchEmployees.service;

import com.ejercicio.ElasticSearchEmployees.dto.request.EmployeeRequestDTO;
import com.ejercicio.ElasticSearchEmployees.dto.response.EmployeeDTO;

public interface IEmployeeService {
    EmployeeDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO );
}
