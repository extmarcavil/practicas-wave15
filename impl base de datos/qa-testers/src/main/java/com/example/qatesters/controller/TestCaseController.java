package com.example.qatesters.controller;

import com.example.qatesters.api.dto.IdCaseDto;
import com.example.qatesters.api.dto.TestCaseDto;
import com.example.qatesters.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<List<TestCaseDto>> getAll(@RequestParam(required = false,name = "last_update")
                                                    @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date){
        return new ResponseEntity<>(service.findAll(date),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTest(@PathVariable Long id,@RequestBody TestCaseDto test){
        return new ResponseEntity<>(service.update(id,test),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity updateTest(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
