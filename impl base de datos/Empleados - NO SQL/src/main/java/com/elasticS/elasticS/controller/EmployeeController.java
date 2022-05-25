package com.elasticS.elasticS.controller;

import com.elasticS.elasticS.Employee;
import com.elasticS.elasticS.EmployeeRepository;
import com.elasticS.elasticS.EmployeeRequestDTO;
import com.elasticS.elasticS.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    IEmployeeService iEmployeeService;

    public EmployeeController(EmployeeRepository employeeRepository, IEmployeeService iEmployeeService) {
        this.employeeRepository = employeeRepository;
        this.iEmployeeService = iEmployeeService;
    }


    @GetMapping
    public ResponseEntity<?> demo(){
        String hello = "HelloWorld";
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeRequestDTO employee){
        return new ResponseEntity<>(iEmployeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/one")
    public ResponseEntity<?> one(@RequestParam Integer age){
        return new ResponseEntity<>(employeeRepository.findEmployeeByAge(age).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/two")
    public ResponseEntity<?> two(@RequestParam Integer age){

        return new ResponseEntity<>(employeeRepository.findAllByAge(age), HttpStatus.OK);
    }

    @GetMapping("/three")
    public ResponseEntity<?> three(@RequestParam String name){
        return new ResponseEntity<>(employeeRepository.findAllByNameLike(name), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(){
        employeeRepository.deleteAll();
        String hello = "HelloWorld";
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }
}
