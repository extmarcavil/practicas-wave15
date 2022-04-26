package dtoresponseentity.ejerpractico.covid19.controller;

import dtoresponseentity.ejerpractico.covid19.dto.PacienteDTO;
import dtoresponseentity.ejerpractico.covid19.dto.SintomaDTO;
import dtoresponseentity.ejerpractico.covid19.exception.NotFoundException;
import dtoresponseentity.ejerpractico.covid19.service.IService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class Controller {

    private final IService service;

    @GetMapping
    public SintomaDTO home(@RequestBody SintomaDTO sintomaDTO){
        return sintomaDTO;
    }

    @GetMapping("findSymptom")
    public List<SintomaDTO> listar(){
        return service.listarSintomas();
    }

    @GetMapping("findSymptom/{name}")
    public SintomaDTO listar(@PathVariable String name){
        return service.buscarPorNombre(name);
    }

    @GetMapping("findRiskPerson")
    public List<PacienteDTO> listarPacientes(){
        return service.listarPacientesRiesgo();
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        Map.of(
                                "error","ERROR 404",
                                "reason",e.getMessage()
                        )
                );

    }

}
