package Bootcamp.Spring.EjCovid.Controller;

import Bootcamp.Spring.EjCovid.Model.Persona;
import Bootcamp.Spring.EjCovid.Model.Sintoma;
import Bootcamp.Spring.EjCovid.Service.SymptomService;
import lombok.Getter;
import org.apache.el.parser.SimpleNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class CovidController {

        SymptomService service;

        public CovidController(){
                service = new SymptomService();
        }

        @GetMapping("/findSymptom")
        public ResponseEntity<List<Sintoma>> showsymptoms (){
                return new ResponseEntity<>(service.getsintomas(), HttpStatus.I_AM_A_TEAPOT);
        }


        @GetMapping("/findSymptom/{name}")
        public ResponseEntity<Sintoma> showsymptomsbyname (@PathVariable String name){
                return new ResponseEntity<>(service.getSintomaEncontrado(name),HttpStatus.OK);
        }


        @GetMapping("/findRiskPerson")
        public ResponseEntity<List<Persona>> personasDeRiesgo(){
                return new ResponseEntity<List<Persona>>(service.getRiesgosos(), HttpStatus.OK);

        }



}
