package com.translatemorse.traductormorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTranslate {
    Utilidades utilidades = new Utilidades();

    @GetMapping("/translate/{morse}")
    public String translate(@PathVariable String morse){
        return utilidades.traducir(morse);
    }

}
