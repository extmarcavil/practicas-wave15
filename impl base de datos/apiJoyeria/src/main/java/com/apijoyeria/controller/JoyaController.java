package com.apijoyeria.controller;

import com.apijoyeria.dto.request.JoyaRequestDTO;
import com.apijoyeria.dto.response.AccionJoyaResponseDTO;
import com.apijoyeria.dto.response.JoyaResponseDTO;
import com.apijoyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<AccionJoyaResponseDTO> crearJoya(@RequestBody JoyaRequestDTO joya){
        return new ResponseEntity<>(joyaService.crearJoya(joya), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{nro_identificatorio}")
    public ResponseEntity<AccionJoyaResponseDTO> eliminarJoya(@PathVariable int nro_identificatorio){
        return new ResponseEntity<>(joyaService.eliminarJoya(nro_identificatorio), HttpStatus.OK);
    }

    @PutMapping("/update/{nro_identificatorio}")
    public ResponseEntity<JoyaResponseDTO> actualizarJoya(@PathVariable int nro_identificatorio,
                                                          @RequestBody JoyaRequestDTO joya){
        return new ResponseEntity<>(joyaService.actualizaJoya(nro_identificatorio,joya), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<JoyaResponseDTO>> todoJoyas(){
        return new ResponseEntity<>(joyaService.todoJoyas(), HttpStatus.OK);
    }

}
