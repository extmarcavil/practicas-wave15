package com.modulo6.calcuDeCalorias.controller;


import com.modulo6.calcuDeCalorias.dto.IngredienteDTO;
import com.modulo6.calcuDeCalorias.dto.PlatoDTO;
import com.modulo6.calcuDeCalorias.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoIngredienteController {

    IngredienteService ingredienteService;

    public PlatoIngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    //ingreso nombre del plato y peso, devuelve cantidad de calorias del plato
    //consulta postman http://localhost:8080/calorias/fideos/300.6
    @GetMapping("/calorias/{nombre}/{peso}")
    public ResponseEntity<PlatoDTO>  caloriasPlato(@PathVariable String nombre, @PathVariable Double peso){
        return new ResponseEntity<>(ingredienteService.caloriasPlato(nombre, peso), HttpStatus.OK);
    }

    //ingreso nombre del plato y peso, devuelve lista de ingredientes que lo conforman y las calorias de cada uno
    //consulta postman http://localhost:8080/ingredientes/fideos/300.6
    @GetMapping("/ingredientes/{nombre}/{peso}")
    public ResponseEntity<List<IngredienteDTO>> ingredientesPlato(@PathVariable String nombre, @PathVariable Double peso){
        return new ResponseEntity<>(ingredienteService.getAllIngredientePlato(nombre, peso), HttpStatus.OK);
    }

    //ingreso nombre del plato y peso, devuelve el ingrediente con mayor caloria del plato
    //consulta postman http://localhost:8080/mayorCaloria/fideos/300.6
    @GetMapping("/mayorCaloria/{nombre}/{peso}")
    public ResponseEntity<IngredienteDTO> ingMayorCaloriaPlato(@PathVariable String nombre, @PathVariable Double peso){
        return new ResponseEntity<>(ingredienteService.getIngredienteMayorCal(nombre, peso), HttpStatus.OK);
    }

}
