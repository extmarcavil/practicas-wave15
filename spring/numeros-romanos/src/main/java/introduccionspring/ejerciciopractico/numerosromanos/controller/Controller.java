package introduccionspring.ejerciciopractico.numerosromanos.controller;

import introduccionspring.ejerciciopractico.numerosromanos.utils.Convert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("toRoman/{number}")
    public String toRoman(@PathVariable Integer number){
        return Convert.convertToRoman(number);
    }

    @GetMapping()
    public String home(){
        return "Bienvenido a Roman Convert!";
    }

}
