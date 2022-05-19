package com.meli.TestCase.controller;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;
import com.meli.TestCase.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TesterController {

    private ITestCaseService service;

    public TesterController(ITestCaseService service) {
        this.service = service;
    }

    //http://localhost:8080/api/testcases/new
    /*
    {
    "desc" : "test",
    "tested": true,
    "passed" : true,
    "number_of_tries": 6,
    "lastUpdate": "17-05-2022"
}
     */
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


    //Actualizar un caso de prueba por id.
    @PutMapping("/{id}")
    public String updateTest (@PathVariable Long id, @RequestBody ReqTestCaseDto test) {
        return service.updateTest(id, test);
    }

    //Eliminar un tutorial por id.
    @DeleteMapping("/{id}")
    public String deleteTest (@PathVariable Long id) {
        return service.deleteTest(id);
    }

    //http://localhost:8080/api/testcases/fecha?last_update=17-05-2022
    @GetMapping("/fecha")
    public ResponseEntity<List<TestCase>> obtenerUnoPorFecha(@RequestParam (name= "last_update") String lastUpdate){
        return new ResponseEntity<>(service.obtenerPorFecha(lastUpdate),HttpStatus.OK);
    }


}