package Bootcamp.Spring.EjCovid.Service;

import Bootcamp.Spring.EjCovid.Model.Persona;
import Bootcamp.Spring.EjCovid.Model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SymptomService {

    private List<Sintoma> sintomas;
    private List<Persona> personas ;

    public SymptomService(){
        this.sintomas = crearSintomas();
        this.personas = crearPersonas();
    }

    public List<Sintoma> getsintomas(){
        return sintomas;
    }

    public List<Persona> getRiesgosos(){
        return personas.stream()
                .filter(p -> p.getEdad() > 60 && !p.getSintomas().isEmpty()).collect(Collectors.toList());
    }

    public Sintoma getSintomaEncontrado(String name){
        return sintomas.stream().
                filter(s -> s.getNombre().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Sintoma> crearSintomas (){
        List<Sintoma> sintomas = new ArrayList<>();
        Sintoma s1 = new Sintoma(1,0,"fiebre");
        Sintoma s2 = new Sintoma(2,4,"headache");
        Sintoma s3 = new Sintoma(3,1,"toz");
        sintomas.add(s1);
        sintomas.add(s2);
        sintomas.add(s3);
        return sintomas;
    }

    public List<Persona> crearPersonas() {
        List<Persona> personas = new ArrayList<>();
        Persona p1 = new Persona(1,25,"Luciano","Barrera",crearSintomas());
        Persona p2 = new Persona(2,67,"oscar","Barrera",crearSintomas());
        Persona p3 = new Persona(3,85,"ruben","Barrera",new ArrayList<>());
        Persona p4 = new Persona(4,65,"marco","Rubiolo",crearSintomas());
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        return personas;

    }

}
