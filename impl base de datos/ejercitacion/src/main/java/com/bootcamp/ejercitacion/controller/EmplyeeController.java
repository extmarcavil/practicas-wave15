package com.bootcamp.ejercitacion.controller;

import com.bootcamp.ejercitacion.dto.EmployeeDTO;
import com.bootcamp.ejercitacion.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employees")
public class EmplyeeController {
    private final EmployeeService employeeService;

    public EmplyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("")
    public ResponseEntity<?> createEmployee (@RequestBody EmployeeDTO employee ) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateEmployee (@PathVariable String id, @RequestBody EmployeeDTO employee ) {
        return new ResponseEntity<>(employeeService.updateEmployee(id,employee), OK);
    }
}
