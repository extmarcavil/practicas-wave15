package com.joyas.ejerciciojoyas.controller;

import com.joyas.ejerciciojoyas.dto.request.JoyaRequestDTO;
import com.joyas.ejerciciojoyas.dto.response.JoyaResponseDTO;
import com.joyas.ejerciciojoyas.model.Joya;
import com.joyas.ejerciciojoyas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    private IJoyaService joyaService;
    public JoyaController(IJoyaService joyaService){
        this.joyaService=joyaService;
    }
    @PostMapping( "/jewerly/new")
    public ResponseEntity<?> createNewJoya(@RequestBody JoyaRequestDTO joya){
        JoyaResponseDTO joyaNueva=joyaService.saveJoya(joya);

         return ResponseEntity.status(HttpStatus.ACCEPTED).body(joyaNueva.getNro_identificatorio());
    }
    @GetMapping( "/jewerly")
    public List<JoyaResponseDTO> getAllJoyas(){
        List<JoyaResponseDTO> listadoJoyas=joyaService.getJoyas();
        return listadoJoyas;
    }
    @PostMapping( "/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        joyaService.deleteJoya(id);
        return ResponseEntity.status(HttpStatus.OK).body("Joya borrada");
    }
    @PostMapping( "/jewerly/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id_modificar,@RequestBody JoyaRequestDTO joya){
        joyaService.updateJoya(id_modificar,joya);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Se modifico la joya "+id_modificar);
    }

}
