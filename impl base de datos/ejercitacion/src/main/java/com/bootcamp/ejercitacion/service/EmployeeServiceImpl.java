package com.bootcamp.ejercitacion.service;

import com.bootcamp.ejercitacion.dto.EmployeeDTO;
import com.bootcamp.ejercitacion.entity.Employee;
import com.bootcamp.ejercitacion.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeeDTO = modelMapper.map(employeeRepository.save(employee),EmployeeDTO.class);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO) {
         if(employeeRepository.existsById(id)){
             Employee employee = modelMapper.map(employeeDTO, Employee.class);
             employee.setId(id);
             employeeDTO = modelMapper.map(employeeRepository.save(employee),EmployeeDTO.class);
             return employeeDTO;
        }else{
                 return null;
             }
    }
}
