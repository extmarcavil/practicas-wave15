package com.spring.ejercicioempleadoselasticsearch.service;

import com.spring.ejercicioempleadoselasticsearch.dto.request.EmployeeRequestDTO;
import com.spring.ejercicioempleadoselasticsearch.dto.response.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    EmployeeDTO addEmployee(EmployeeRequestDTO employeeDTO);

    Object getAll();

    Optional<?> getEmployeeByEdad(Integer edad);

    List<EmployeeDTO> getEmployeesByName(String name);
}
