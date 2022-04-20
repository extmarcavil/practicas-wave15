package introspring.ejerciciopractico.codigomorse.controller;

import introspring.ejerciciopractico.codigomorse.utils.Traductor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/convert")
public class MorseController {

    @GetMapping("/{palabraMorse}")
    public String getPalabra(@PathVariable String palabraMorse){
        return Traductor.traducir(palabraMorse);
    }
    @GetMapping
    public String getPalabra(){
        return "Bienvenido al Morse Convert!!";
    }

}
