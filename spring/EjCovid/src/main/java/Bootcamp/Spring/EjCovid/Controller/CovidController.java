package Bootcamp.Spring.EjCovid.Controller;

import Bootcamp.Spring.EjCovid.Model.Sintoma;
import lombok.Getter;
import org.apache.el.parser.SimpleNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class CovidController {

        @GetMapping("/findSymptom")
        public ResponseEntity<ArrayList<Sintoma>> showsymptoms (){
                ArrayList<Sintoma> sintomas = crearSintomas();
                return new ResponseEntity<ArrayList<Sintoma>>(sintomas, HttpStatus.I_AM_A_TEAPOT);
        }

        @GetMapping("findSymptom/{name}")
        public ResponseEntity<Integer> showsymptomsbyname (@PathVariable String name){
                ArrayList<Sintoma> sintomas = crearSintomas();
                for (Sintoma s: sintomas) {
                        if (Objects.equals(s.getNombre(), name)) {
                                return new ResponseEntity<Integer>(s.getNivel_de_gravedad(), HttpStatus.I_AM_A_TEAPOT);
                        }
                }
                return new ResponseEntity<Integer>(123456789,HttpStatus.BAD_REQUEST);
        }

        public ArrayList<Sintoma> crearSintomas (){
                ArrayList<Sintoma> sintomas = new ArrayList<>();
                Sintoma s1 = new Sintoma(1,0,"fiebre");
                Sintoma s2 = new Sintoma(2,4,"headache");
                Sintoma s3 = new Sintoma(3,1,"toz");
                sintomas.add(s1);
                sintomas.add(s2);
                sintomas.add(s3);
                return sintomas;

        }
}
