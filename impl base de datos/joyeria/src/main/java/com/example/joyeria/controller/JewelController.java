package com.example.joyeria.controller;

import com.example.joyeria.api.dto.JewelDto;
import com.example.joyeria.api.dto.NroIdentificatorioDto;
import com.example.joyeria.service.JewelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jewerly")
public class JewelController {

    private final JewelService jewelService;

    @PostMapping(value = "/new")
    public NroIdentificatorioDto createJewel(@RequestBody JewelDto jewel){
        return jewelService.create(jewel);
    }

    @GetMapping
    public List<JewelDto> getAll(){
        return jewelService.findAll();
    }


}
