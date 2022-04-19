package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.NumerosRomanosService;

@RestController
public class NumerosRomanosController {

    //region Variables
    private NumerosRomanosService _numerosRomanosService;
    //endregion

    //region Constructor

    public NumerosRomanosController() {
        _numerosRomanosService = new NumerosRomanosService();
    }

    //endregion

    //region End Points
    @GetMapping("/numerosromanos/{numeroDecimal}")
    public  String numerodecimalRomano(@PathVariable int numeroDecimal){
        return  "El nùmero: " + numeroDecimal + " , en romano es: " + _numerosRomanosService.convertDecimalRomano(numeroDecimal);
    }
    //endregion

}
