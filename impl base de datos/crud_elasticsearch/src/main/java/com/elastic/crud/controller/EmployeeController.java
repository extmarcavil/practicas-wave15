package com.elastic.crud.controller;


import com.elastic.crud.dto.request.EmployeeRequestDTO;
import com.elastic.crud.model.Employee;
import com.elastic.crud.repository.EmployeeRepository;
import com.elastic.crud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService){

        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeRequestDTO), HttpStatus.OK);
    }
    @GetMapping("/one")
    public ResponseEntity<?> get(@RequestParam Integer age){
        return new ResponseEntity<>(employeeRepository.findAllByAge(age), HttpStatus.OK);
    }
    @GetMapping("/two")
    public ResponseEntity<?> get2(@RequestParam Integer age){
        return new ResponseEntity<>(employeeRepository.findEmployeeByAge(age), HttpStatus.OK);
    }
    @GetMapping("/three")
    public ResponseEntity<?> get3(@PathVariable String id ){
        return new ResponseEntity<>(employeeRepository.findById(id), HttpStatus.OK);
    }
    @GetMapping("/four")
    public ResponseEntity<?> get4(@RequestParam String name){
        return new ResponseEntity<>(employeeRepository.findAllByNameLike(name), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> demo01(@PathVariable String id){
        return new ResponseEntity<>( HttpStatus.OK);
    }



}