package com.elasticS.elasticS.service;

import com.elasticS.elasticS.Employee;
import com.elasticS.elasticS.EmployeeRepository;
import com.elasticS.elasticS.EmployeeRequestDTO;
import com.elasticS.elasticS.EmployeeResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    ModelMapper mapper;

    @Override
    public EmployeeResponseDTO saveEmployee (EmployeeRequestDTO employeeRequestDTO){

        Employee employee = mapper.map(employeeRequestDTO, Employee.class);
        employeeRepository.save(employee);
        //mapeamos la entidad a un dto de respuesta
        return mapper.map(employee, EmployeeResponseDTO.class);
    }
}
