package com.example.qatesters.controller;

import com.example.qatesters.api.dto.IdCaseDto;
import com.example.qatesters.api.dto.TestCaseDto;
import com.example.qatesters.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestCaseController {

    private final TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<IdCaseDto> createTest(@RequestBody TestCaseDto test){
        return new ResponseEntity<>(service.create(test), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDto>> getAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTest(@PathVariable Long id,@RequestBody TestCaseDto test){
        return new ResponseEntity<>(service.update(id,test),HttpStatus.OK);
    }
}
