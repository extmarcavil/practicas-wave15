package com.elastic.crud.service;

import com.elastic.crud.dto.request.EmployeeRequestDTO;
import com.elastic.crud.dto.response.EmployeeDTO;
import com.elastic.crud.model.Employee;
import com.elastic.crud.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  implements  IEmployeeService{

    EmployeeRepository employeeRepository;
    ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
        mapper = new ModelMapper();
    }
    @Override
    public EmployeeDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO) {

        //mapeo el dto de request a entity
        Employee employeeModel =  mapper.map(employeeRequestDTO, Employee.class);

        //guardamos entity
        employeeRepository.save(employeeModel);


        //mapeo de entidad a DTO de respuesta
        return mapper.map(employeeModel, EmployeeDTO.class);
    }
}
