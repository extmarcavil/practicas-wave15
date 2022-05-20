package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.EmployeeDto;
import com.bootcamp.elastic.model.Employee;
import com.bootcamp.elastic.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(IEmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
        mapper = new ModelMapper();
    }

    @Override
    public EmployeeDto save(EmployeeDto employee) {
        /*Employee e = mapper.map(employee, Employee.class);
        Employee e2 = employeeRepository.save(e);
        EmployeeDto ed = mapper.map(e2, EmployeeDto.class);
        return ed;*/
        return mapper.map(
                employeeRepository.save(mapper.map(employee, Employee.class)),
                EmployeeDto.class);
    }
}
