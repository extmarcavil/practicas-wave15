package com.covid.spring;

import com.covid.spring.entidades.Persona;
import com.covid.spring.entidades.Sintoma;
import com.covid.spring.entidades.SintomaticoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class controller {


    @GetMapping("/findSymptom")
    public List<Sintoma> findAllSintomas(){
        return getAllSintomas();


    }


    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSintoma(@PathVariable String name){
        Sintoma aux= findAllSintomas().stream().filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name)).findFirst().get();
        System.out.println(aux.getNombre());

        return new ResponseEntity<Sintoma>(aux, HttpStatus.OK);
    }


    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<SintomaticoDTO>> findPersonas(){
        List<Persona> mayores60= getPersonas().stream().filter(persona -> persona.getEdad()>=60).collect(Collectors.toList());
        List<SintomaticoDTO> sintomaticos = new ArrayList<>();
        for(int i=0;i<mayores60.size();i++){
            sintomaticos.add(new SintomaticoDTO(mayores60.get(i).getNombre().concat(mayores60.get(i).getApellido()),mayores60.get(i).getEdad(),getAllSintomas().get(i)));
        }

        return new ResponseEntity<List<SintomaticoDTO>>(sintomaticos,HttpStatus.OK);
    }








    public List<Sintoma> getAllSintomas(){
        List<Sintoma> sintomas= new ArrayList<>();
        Sintoma fiebre= new Sintoma(1,"fiebre",1);
        Sintoma vomitos= new Sintoma(2,"vomitos",1);
        Sintoma dolorDePecho= new Sintoma(3,"dolor de pecho",3);

        sintomas.add(fiebre);
        sintomas.add(vomitos);
        sintomas.add(dolorDePecho);

        return sintomas;



    }

    public List<Persona> getPersonas(){
        List<Persona> personas= new ArrayList<>();
        personas.add(new Persona(1,"fabian","escalona",62));
        personas.add(new Persona(2,"juan","perez",14));
        return personas;
    }




}
