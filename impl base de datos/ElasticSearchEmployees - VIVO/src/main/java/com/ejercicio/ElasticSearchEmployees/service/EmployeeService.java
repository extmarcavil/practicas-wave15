package com.ejercicio.ElasticSearchEmployees.service;

import com.ejercicio.ElasticSearchEmployees.dto.request.EmployeeRequestDTO;
import com.ejercicio.ElasticSearchEmployees.dto.response.EmployeeDTO;
import com.ejercicio.ElasticSearchEmployees.entity.Employee;
import com.ejercicio.ElasticSearchEmployees.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{

    EmployeeRepository employeeRepository;

    ModelMapper mapper; // podriamos usar el patron converter para abstraernos de la forma de mapear

    public EmployeeService ( EmployeeRepository employeeRepository, ModelMapper mapper ) {
        this.employeeRepository = employeeRepository;
        this.mapper             = mapper;
    }

    @Override
    public EmployeeDTO saveEmployee (EmployeeRequestDTO employeeRequestDTO ) {
        // mapeamos el dto de request a una entidad
        Employee employeeModel = mapper.map(employeeRequestDTO, Employee.class);

        // usamos la entidad
        employeeRepository.save(employeeModel);

        // mapeamos al entidad a un dto de respuesta
        return mapper.map(employeeModel, EmployeeDTO.class);
    }
}