package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarreraSelva {

    List<Persona> carreraCorta = new ArrayList<Persona>();
    List<Persona> carreraMedia = new ArrayList<Persona>();
    List<Persona> carrearLarga = new ArrayList<Persona>();

    public String inscripcion (int dni, String nombre, String apellido, int edad, int celular, String sangre, String circuito) {

        Persona inscripto = new Persona(numeroDeInscripcion(circuito), dni, nombre, apellido, edad, celular, sangre );

        if (circuito == "corta") {
            carreraCorta.add(inscripto);
        } else {
            if (circuito == "medio") {
                carreraMedia.add(inscripto);
            } else {
                carrearLarga.add(inscripto);
            }
        }
        return "La persona " + nombre + " " + apellido + " tendra el id " + inscripto.getNumeroInscripcion() + " en el circuito " + circuito + " y debera pagar " + valorCarrera(edad, circuito);
    }

    public int numeroDeInscripcion (String carrera) {
        if (carrera == "corta") {
            return carreraCorta.size()+1;
        } else {
            if (carrera == "medio") {
                return carreraMedia.size()+1;
            } else {
                return carrearLarga.size()+1;
            }
        }
    }

    public int valorDeCarreraMayores (String carrera) {
        if (carrera == "corta") {
            return 1500;
        } else {
            if (carrera == "medio") {
                return 2300;
            } else {
                return 2800;
            }
        }
    }

    public int valorDeCarreraMenores (String carrera) {
        if (carrera == "corta") {
            return 1300;
        } else {
            return 2000;
        }
    }

    public int valorCarrera (int edad, String circuito) {
        if (edad >= 18) {
            return valorDeCarreraMayores(circuito);
        } else {
            return valorDeCarreraMenores(circuito);
        }
    }

    public String obtenerInscriptos (String circuito) {
        List<Persona> lista;
        String listado = "";
        if (circuito == "corta") {
            lista = carreraCorta;
        } else {
            if (circuito == "medio") {
                lista = carreraMedia;
            } else {
                lista = carrearLarga;
            }
        }
        for (Persona person : lista) {
            listado += "Inscripto nro " + person.getNumeroInscripcion() + " en carrera " + circuito + " es " + person.getNombre() + " " + person.getApellido() + "\n";
        }
        return listado;
    }
}
