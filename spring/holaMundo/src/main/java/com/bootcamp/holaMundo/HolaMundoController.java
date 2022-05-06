package com.bootcamp.holaMundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/saludo/{name}")
    public String saludar(@PathVariable String name) {
        return "Hola " + name;
    }
}
