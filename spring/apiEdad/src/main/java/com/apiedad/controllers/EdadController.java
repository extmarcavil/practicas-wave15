package com.apiedad.controllers;

import com.apiedad.services.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    //region Variables
    @Autowired
    private IEdadService _edadService;
    //endregion

    //region End Points
    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int anio) throws Exception {
        try{
            return "Tù edad es: " + _edadService.obtenerEdad(dia,mes,anio);
        }
        catch (Exception e){
            throw  e;
        }
    }
    //endregion

}
