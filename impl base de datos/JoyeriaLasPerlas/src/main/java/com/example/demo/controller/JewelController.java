package com.example.demo.controller;

import com.example.demo.dto.GetResponseDTO;
import com.example.demo.dto.JewelDTO;
import com.example.demo.dto.JewelListDTO;
import com.example.demo.model.Jewel;
import com.example.demo.service.IJewelService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/jewerly")
@RestController
public class JewelController {

    private final IJewelService jewelService;
    private final ModelMapper map;
    public JewelController(IJewelService jewelService)
    {
        map = new ModelMapper();
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveJewel(@RequestBody JewelDTO jewel )
    {
        System.out.println(jewel.getVentaONo());
        Long id = jewelService.saveJewel(map.map(jewel,Jewel.class));
        return new ResponseEntity<>(new GetResponseDTO(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Jewel>> getJewels()
    {
        List<Jewel> jewels = jewelService.getJewels();
        return new ResponseEntity<>(jewels, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> logicalDeleteJewel(@PathVariable Long id)
    {
        Jewel jewel = jewelService.findJewel(id);
        if (jewel == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jewel.setVentaONo(false);
        jewelService.saveJewel(jewel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
