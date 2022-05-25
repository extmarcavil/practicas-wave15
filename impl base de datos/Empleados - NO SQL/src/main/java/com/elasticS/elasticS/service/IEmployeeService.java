package com.elasticS.elasticS.service;

import com.elasticS.elasticS.EmployeeRequestDTO;
import com.elasticS.elasticS.EmployeeResponseDTO;

public interface IEmployeeService {
    EmployeeResponseDTO saveEmployee (EmployeeRequestDTO employeeRequestDTO);
}
