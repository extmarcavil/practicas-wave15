package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaRequestDTO;
import com.example.joyeria.dto.JoyaRequestUpdateDTO;
import com.example.joyeria.dto.JoyaResponseDTO;
import com.example.joyeria.service.IJoyaService;
import com.example.joyeria.service.JoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private IJoyaService joyaService;

    public JoyaController(JoyaService joyaService){
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    ResponseEntity<String> newJoya(@Valid @RequestBody JoyaRequestDTO newJoya){
        Long id = joyaService.save(newJoya);
        return ResponseEntity.ok("Id nueva joya: " + id);
    }
    @PutMapping("/update/{id_modificar}")
    ResponseEntity<JoyaResponseDTO> updateById(@Valid @RequestBody JoyaRequestUpdateDTO newJoya,
                                            @PathVariable(name = "id_modificar") Long id){
        return ResponseEntity.ok(joyaService.updateById(id, newJoya));
    }
    @GetMapping()
    ResponseEntity<List<JoyaResponseDTO>> findAll(){
        return ResponseEntity.ok(joyaService.findAll());
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id){
        joyaService.deleteById(id);
        return ResponseEntity.ok("Joya con id " + id + " eliminada exitosamente.");
    }

}
