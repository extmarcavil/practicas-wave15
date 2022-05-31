package com.spring.ejercicioempleadoselasticsearch.service;

import com.spring.ejercicioempleadoselasticsearch.domain.Employee;
import com.spring.ejercicioempleadoselasticsearch.dto.request.EmployeeRequestDTO;
import com.spring.ejercicioempleadoselasticsearch.dto.response.EmployeeDTO;
import com.spring.ejercicioempleadoselasticsearch.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }


    @Override
    public EmployeeDTO addEmployee(EmployeeRequestDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        var result = employeeRepository.save(employee);
        return mapper.map(result, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<?> getEmployeeByEdad(Integer edad) {
        var result = employeeRepository.findEmployeeByEdad(edad);
        Optional<?> res;
        if (result.orElse(null) == null) {
            res = Optional.ofNullable(null);
        } else {
            res = Optional.ofNullable(mapper.map(result.orElse(null), EmployeeDTO.class));
        }
        return res;
    }

    @Override
    public List<EmployeeDTO> getEmployeesByName(String name) {
        return employeeRepository.findAllByNameLike(name)
                .stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
