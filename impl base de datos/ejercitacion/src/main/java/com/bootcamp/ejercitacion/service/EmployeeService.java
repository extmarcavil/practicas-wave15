package com.bootcamp.ejercitacion.service;

import com.bootcamp.ejercitacion.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee (EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee (String id, EmployeeDTO employeeDTO);
}
