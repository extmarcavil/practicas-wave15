package com.elastic.crud.service;

import com.elastic.crud.dto.request.EmployeeRequestDTO;
import com.elastic.crud.dto.response.EmployeeDTO;

public interface IEmployeeService {

    EmployeeDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO);
}
