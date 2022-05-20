package com.meli.TestCase.controller;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<List<TestCase>> obtenerTodos(@RequestParam(required=false) String last_update){
        return new ResponseEntity<>(service.obtenerTodos(last_update),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> obtenerUnoPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.obtenerPorId(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResPostTestDto> actualizarPorId(@PathVariable Long id, @RequestBody ReqTestCaseDto test){
        return new ResponseEntity<>(service.actualizarPorId(id, test),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable Long id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}