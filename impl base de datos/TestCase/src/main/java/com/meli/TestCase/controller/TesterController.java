package com.meli.TestCase.controller;

import com.meli.TestCase.Dto.ReqTestDto;
import com.meli.TestCase.Dto.ResTestDto;
import com.meli.TestCase.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TesterController {

    private final ITestCaseService service;

    public TesterController(ITestCaseService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<ResTestDto> createTestCase(@RequestBody ReqTestDto test){
        return new ResponseEntity<>(service.saveTest(test), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<ResTestDto>> getTests(@RequestParam(required = false) String lastUpdate){
        return new ResponseEntity<>(service.getTests(lastUpdate),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResTestDto> getTestById(@PathVariable Long id){
        return new ResponseEntity<>(service.getTestById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResTestDto> updateTestCase(@PathVariable Long id, @RequestBody ReqTestDto newData){
        return new ResponseEntity<>(service.updateTest(id, newData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteTest(id), HttpStatus.OK);
    }
}