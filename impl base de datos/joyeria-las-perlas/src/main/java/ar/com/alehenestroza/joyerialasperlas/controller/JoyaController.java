package ar.com.alehenestroza.joyerialasperlas.controller;

import ar.com.alehenestroza.joyerialasperlas.dto.request.JoyaDTO;
import ar.com.alehenestroza.joyerialasperlas.service.JoyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
@RequiredArgsConstructor
public class JoyaController {
    private final JoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody JoyaDTO joya) {
        return ResponseEntity.ok("Joya guardada. ID: " + joyaService.saveJoya(joya));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(joyaService.getJoyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity.ok("Eliminada joya " + joyaService.deleteJoya(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody JoyaDTO joyaDTO) {
        return ResponseEntity.ok(joyaService.update(id, joyaDTO));
    }
}
