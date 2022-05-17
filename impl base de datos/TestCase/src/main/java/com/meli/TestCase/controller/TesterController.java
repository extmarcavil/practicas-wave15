package com.meli.TestCase.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.service.ITestCaseService;
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
    public ResponseEntity<List<TestCase>> obtenerTodos(){
        return new ResponseEntity<>(service.obtenerTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> obtenerUnoPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.obtenerPorId(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> actualizarTest(@PathVariable Long id,
                                                         @RequestBody ReqTestCaseDto test){
        return new ResponseEntity<>(service.actualizar(id,test), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarTest(@PathVariable Long id){
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

    @GetMapping("/testfecha")
    public ResponseEntity<List<TestCase>> testXFecha(@RequestParam   String  last_update){
        return new ResponseEntity<>(service.testxFecha(LocalDate.parse(last_update)),HttpStatus.OK);
    }

}