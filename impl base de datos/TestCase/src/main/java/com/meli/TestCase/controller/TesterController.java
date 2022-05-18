package com.meli.TestCase.controller;

import com.meli.TestCase.dto.ReqTestCaseDto;
import com.meli.TestCase.dto.ResPostTestDto;
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

    @GetMapping()
    public ResponseEntity<List<TestCase>> obtenerTodos(){
        return new ResponseEntity<>(service.obtenerTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> obtenerUnoPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.obtenerPorId(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> actualizarUnoPorId(@RequestBody ReqTestCaseDto testCase, @PathVariable Long id){
        return new ResponseEntity<>(service.actualizarPorId(testCase, id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUnoPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Borrado correctamente",HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<TestCase>> obtenerUnoPorId(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate last_update){
        return new ResponseEntity<>(service.buscarPorFecha(last_update),HttpStatus.OK);
    }

}