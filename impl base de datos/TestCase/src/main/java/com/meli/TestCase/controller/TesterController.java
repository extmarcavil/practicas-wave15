package com.meli.TestCase.controller;

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
    public ResponseEntity<ResPostTestDto> crearRegistroTest(@RequestBody ReqTestCaseDto test) {
        return new ResponseEntity<>(service.guardar(test), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCase>> obtenerTodos(@RequestParam(name = "last_update", defaultValue = "", required = false) String lastUpdate) {
        List<TestCase> result = service.obtenerTodos(lastUpdate);
        if(result == null){
            // POr cuestiones de tiempo y para cumplir la tarea validamos este error, en caso de que la fecha tenga un formato invalido.
            // Lo mas conveniente seria implementar una clase @ControllerAdvice para gestionar todos los errores.
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> obtenerUnoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.obtenerPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarRegistroTest(@PathVariable Long id, @RequestBody ReqTestCaseDto test) {
        service.actualizar(id, test);
        return new ResponseEntity<>("Datos catualizados correctamente", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUnoPorId(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>("Eliminado correctamente", HttpStatus.ACCEPTED);
    }

}