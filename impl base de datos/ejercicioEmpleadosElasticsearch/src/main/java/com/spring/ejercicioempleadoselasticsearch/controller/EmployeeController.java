package com.spring.ejercicioempleadoselasticsearch.controller;

import com.spring.ejercicioempleadoselasticsearch.domain.Employee;
import com.spring.ejercicioempleadoselasticsearch.dto.request.EmployeeRequestDTO;
import com.spring.ejercicioempleadoselasticsearch.repository.EmployeeRepository;
import com.spring.ejercicioempleadoselasticsearch.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<?> getEmployees() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> newEmployee(@RequestBody EmployeeRequestDTO employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/one")
    public ResponseEntity<?> getEmployeeByEdad(@RequestParam Integer edad) {
        return new ResponseEntity<>(employeeService.getEmployeeByEdad(edad).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }
}
