package com.example.joyeria.controller;

import com.example.joyeria.model.Joya;
import com.example.joyeria.service.IJoyasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jewerly")
public class JoyasController {

    private IJoyasService joyasService;

    public JoyasController(IJoyasService joyasService) {
        this.joyasService = joyasService;
    }

    @PostMapping("new")
    public ResponseEntity<?> createJoya(@RequestBody Joya joya) {
        return ResponseEntity.ok("Numero identificatorio: " + joyasService.saveJoya(joya).getNroIdentificatorio());
    }

    @GetMapping("")
    public ResponseEntity<?> getJoyas() {
        return ResponseEntity.ok(joyasService.getJoyas());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id) {
        joyasService.deleteJoya(id);
        return ResponseEntity.ok("Joya eliminada");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id, @RequestBody Joya joya) {
        joya.setNroIdentificatorio(id);
        return ResponseEntity.ok(joyasService.saveJoya(joya));
    }
}
