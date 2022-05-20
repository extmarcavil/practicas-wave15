package com.ejercicio.ElasticSearchEmployees.controller;

import com.ejercicio.ElasticSearchEmployees.dto.request.EmployeeRequestDTO;
import com.ejercicio.ElasticSearchEmployees.repository.EmployeeRepository;
import com.ejercicio.ElasticSearchEmployees.service.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    IEmployeeService employeeService;

    public EmployeeController (EmployeeRepository employeeRepository, IEmployeeService employeeService ) {
        this.employeeRepository = employeeRepository;
        this.employeeService    = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<?> demo () {
        return new ResponseEntity<>(employeeRepository.findAll(), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create ( @RequestBody EmployeeRequestDTO employee ) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), OK);
    }

    @GetMapping("/one")
    public ResponseEntity<?> demo2 (@RequestParam Integer age) {
        return new ResponseEntity<>(employeeRepository.findEmployeeByAgeGreaterThan(age).orElse(null), OK);
    }

    @GetMapping("/two")
    public ResponseEntity<?> demo3 (@RequestParam Integer age) {
        return new ResponseEntity<>(employeeRepository.findAllByAge(age), OK);
    }

    @GetMapping("/three")
    public ResponseEntity<?> demo4 (@RequestParam String name) {
        return new ResponseEntity<>(employeeRepository.findAllByNameLike(name), OK);
    }

    @DeleteMapping("/sinwhere")
    public ResponseEntity<?> demo4 () {
        employeeRepository.deleteAll();
        String helloWorld = "Se han eliminado todos los registros";
        return new ResponseEntity<>(helloWorld, OK);
    }
}
