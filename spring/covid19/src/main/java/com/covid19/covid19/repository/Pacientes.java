package com.covid19.covid19.repository;

import com.covid19.covid19.model.Paciente;
import com.covid19.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pacientes {
    private static List<Paciente> pacientes;

    public Pacientes() {
        pacientes = new ArrayList<>();
        pacientes.add(new Paciente(1, "Cosme", "Fulanito", 50, Arrays.asList(new Sintoma("1","Fiebre",3),new Sintoma("5","Dificultad respiratoria",5))));
        pacientes.add(new Paciente(2,"Homero","Jay",60,Arrays.asList(new Sintoma("6","Perdida de gusto",1))));
        pacientes.add(new Paciente(3,"Homero","Thonson",78,Arrays.asList(new Sintoma("6","Perdida de olfato",1))));
        pacientes.add(new Paciente(4,"Max","Power",40,Arrays.asList(new Sintoma("4","Tos",2))));
        pacientes.add(new Paciente(5,"Sara","Curvas",90,Arrays.asList(new Sintoma("3","Diarrea",4))));
        pacientes.add(new Paciente(6,"Pechugas","Larousse",18,Arrays.asList(new Sintoma("5","Dificultad respiratoria",5))));
        pacientes.add(new Paciente(7,"Margue","Simpson",35,Arrays.asList(new Sintoma("7","Asintomatico",0))));
    }

    public Paciente buscarNombre( String nombrePaciente){
        return pacientes.stream().filter(paciente -> paciente.getNombre().equals(nombrePaciente)).findFirst().get();
    }

    public Paciente buscarApellido( String apellidoPaciente){
        return pacientes.stream().filter(paciente -> paciente.getApellido().equals(apellidoPaciente)).findFirst().get();
    }

    public List<Paciente> pacientesMayores60(){
        return pacientes.stream().filter(paciente -> paciente.getEdad()>=60).collect(Collectors.toList());
    }
}
