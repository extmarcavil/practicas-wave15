package sport.exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sport.exercise.dto.SportDTO;
import sport.exercise.service.SportServiceInterface;

import java.util.ArrayList;

@RestController
@RequestMapping("/findSport/")
public class SportController {

    private final SportServiceInterface sportService;

    public SportController(SportServiceInterface aService){
        this.sportService = aService;
    }

    @GetMapping
    ResponseEntity<ArrayList<SportDTO>> showAllSports(){
        return new ResponseEntity<>(sportService.getAllSports(),HttpStatus.OK);
    }

    @GetMapping("{name}")
    ResponseEntity<SportDTO> showAllSports(@PathVariable String name){
        return new ResponseEntity<>(sportService.getSport(name),HttpStatus.OK);
    }

}
