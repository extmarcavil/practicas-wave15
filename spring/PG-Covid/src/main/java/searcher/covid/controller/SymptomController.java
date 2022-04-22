package searcher.covid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searcher.covid.dto.SymptomDTO;
import searcher.covid.service.SymptomServiceInterface;

import java.util.ArrayList;

@RestController
@RequestMapping("/findSymptom")
public class SymptomController {

    private final SymptomServiceInterface symptomService;

    public SymptomController(SymptomServiceInterface aService){
        this.symptomService = aService;
    }

    @GetMapping
    ResponseEntity<ArrayList<SymptomDTO>> showAllSymptoms(){
        return new ResponseEntity<>(symptomService.getAllSymptoms(),HttpStatus.OK);
    }

    @GetMapping("/{name}")
    ResponseEntity<SymptomDTO> showRickLevel(@PathVariable String name){
        return new ResponseEntity<>(symptomService.getRiskLevelOf(name),HttpStatus.OK);
    }

}
