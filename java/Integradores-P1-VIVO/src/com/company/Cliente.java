package com.company;

import com.company.paqueteTuristico.PaqueteTuristico;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    /**
     * Atributos
     */
    private String nombre;
    private String apellido;
    private Integer dni;

    private List<PaqueteTuristico> reservasHechas;


    /**
     * Constructor
     */
    public Cliente() {
    }

    public Cliente(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.reservasHechas = new ArrayList<>();
    }


    /**
     * Metodos
     */
    public void addReserva(PaqueteTuristico reserva) {
        reservasHechas.add(reserva);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }


    /**
     * Getter & Setter
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public List<PaqueteTuristico> getReservasHechas() {
        return reservasHechas;
    }
}
