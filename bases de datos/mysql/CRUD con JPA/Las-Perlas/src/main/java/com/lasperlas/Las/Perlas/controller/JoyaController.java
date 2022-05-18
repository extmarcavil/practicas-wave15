package com.lasperlas.Las.Perlas.controller;

import com.lasperlas.Las.Perlas.dto.requestDTO.RequestJoyaDTO;
import com.lasperlas.Las.Perlas.dto.responseDTO.ResponseJoyaDTO;
import com.lasperlas.Las.Perlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/joya")
public class JoyaController {

    private IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService){
        this.joyaService = joyaService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseJoyaDTO> createJoya(@RequestBody RequestJoyaDTO joya){
        return new ResponseEntity<ResponseJoyaDTO>(joyaService.saveJoya(joya), HttpStatus.CREATED);
    }
}
