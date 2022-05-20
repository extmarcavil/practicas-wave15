package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.EmployeeDto;

public interface IEmployeeService {
    EmployeeDto save(EmployeeDto employee);
}
