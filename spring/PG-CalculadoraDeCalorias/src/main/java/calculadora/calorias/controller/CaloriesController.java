package calculadora.calorias.controller;

import calculadora.calorias.dto.FoodDTO;
import calculadora.calorias.service.IMeals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calorias")
public class CaloriesController {

    private final IMeals mealsService;

    public CaloriesController(IMeals mealsService) {
        this.mealsService = mealsService;
    }

    @GetMapping("/{plato}")
    public ResponseEntity<FoodDTO> showCalories(@PathVariable String plato){
        return new ResponseEntity<>(mealsService.getCalories(plato), HttpStatus.OK);
    }
}
