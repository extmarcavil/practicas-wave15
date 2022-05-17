package com.meli.TestCase.controller;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TesterController {

    private ITestCaseService service;

    public TesterController(ITestCaseService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<ResPostTestDto> create(@RequestBody ReqTestCaseDto test){
        return new ResponseEntity<>(service.save(test), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCase>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResPostTestDto> update(@PathVariable Long id, @RequestBody ReqTestCaseDto test){
        return new ResponseEntity<>(service.update(id, test), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteById(id),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TestCase>> searchByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastUpdate){
        return new ResponseEntity<>(service.searchByDate(lastUpdate), HttpStatus.OK);
    }
}