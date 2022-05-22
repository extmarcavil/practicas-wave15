package com.meli.TestCase.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    public ResponseEntity<ResPostTestDto> crearRegistroTest(@RequestBody ReqTestCaseDto test){
        return new ResponseEntity<>(service.guardar(test), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCase>> obtenerTodos(@RequestParam (required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate last_update){
        return new ResponseEntity<>(service.obtenerTodos(last_update),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> obtenerUnoPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.obtenerPorId(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarUnoPorId(@PathVariable Long id){
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResPostTestDto> updatePorId(@PathVariable Long id,@RequestBody ReqTestCaseDto test){

        return new ResponseEntity<>(service.modificar(id,test),HttpStatus.OK);
    }


}