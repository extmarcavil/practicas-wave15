package miPrimerProyecto.holaMundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @GetMapping
    public String hello(){
        return "Hola Mundo";
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable String name){
        return "Hola " + name + "!!!";
    }

    @GetMapping("/hola/{name}")
    public String helloDesdeOtroPath(@PathVariable String name){
        //La variable tiene que tener el mismo nombre que la var encerrada entre corchetes
        return "Hola desde un path distinto " + name + "!!!";
    }

}
