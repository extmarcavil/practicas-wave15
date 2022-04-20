package ar.com.mercadolibre.bootcamp.helloSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    @GetMapping("/hello/{name}")
    public String helloSpring(@PathVariable String name) {
        return "Hello " + name;
    }
}
