package com.spring.ejercicioqatester.controller;

import com.spring.ejercicioqatester.dto.request.ReqTestCaseDTO;
import com.spring.ejercicioqatester.dto.response.RespTestCaseDTO;
import com.spring.ejercicioqatester.service.ITesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TesterController {

    private final ITesterService testerService;

    public TesterController(ITesterService testerService) {
        this.testerService = testerService;
    }


    //CREATE
    @PostMapping("/new")
    public ResponseEntity<RespTestCaseDTO> createRegistroTest(@RequestBody ReqTestCaseDTO testCaseDTO) {
        return new ResponseEntity(testerService.saveTestCase(testCaseDTO), HttpStatus.OK);
    }

    //READ all
    @GetMapping("/list")
    public ResponseEntity<List<RespTestCaseDTO>> readAllTest() {
        return new ResponseEntity(testerService.getAllTest(), HttpStatus.OK);
    }

    //READ one
    @GetMapping("/{id}")
    public ResponseEntity<RespTestCaseDTO> readTest(@PathVariable Long id) {
        return new ResponseEntity(testerService.getTestById(id), HttpStatus.OK);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<RespTestCaseDTO> updateTest(@PathVariable Long id,
                                                      @RequestBody ReqTestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testerService.updateTest(id, testCaseDTO), HttpStatus.OK);
    }

}
