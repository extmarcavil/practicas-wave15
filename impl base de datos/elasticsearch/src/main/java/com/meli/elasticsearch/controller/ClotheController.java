package com.meli.elasticsearch.controller;

import com.meli.elasticsearch.dto.ClotheDto;
import com.meli.elasticsearch.service.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/elastic/clothe")
public class ClotheController {

    private final ClotheService clotheService;

    @Autowired
    public ClotheController(ClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @PostMapping
    public void save(@RequestBody ClotheDto clotheDto) {
        clotheService.save(clotheDto);
    }

    @GetMapping
    public List<ClotheDto> findAll() {
        return clotheService.findAllAsDto();
    }

    @GetMapping("code/{code}")
    public ClotheDto findByCode(@PathVariable UUID code) {
        return clotheService.findByCode(code);
    }

    @DeleteMapping("{code}")
    public void deleteClotheByCode(@PathVariable UUID code) {
        clotheService.deleteByCode(code);
    }

    @GetMapping("size/{size}")
    public List<ClotheDto> findAllBySize(@PathVariable String size) {
        return clotheService.findAllBySize(size);
    }

    @GetMapping("name")
    public List<ClotheDto> findAllByName(@RequestParam String name) {
        return clotheService.findAllByName(name);
    }
}
