package com.bootcamp.empleados.controller;

import com.bootcamp.empleados.model.Employee;
import com.bootcamp.empleados.repository.IEmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
