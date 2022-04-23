package ejerpracticosp2vivo.calculadora.calculadoradecalorias.controller;

import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.request.IngredienteDTO;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class InfoComidaController {

    private IService service;

    @GetMapping("/calorias")
    ResponseEntity<?> getInfoComida(@RequestBody List<IngredienteDTO> ingredientes){
        return ResponseEntity.ok(service.getInfoComida(ingredientes));
    }


}
