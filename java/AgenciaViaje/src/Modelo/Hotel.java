package Modelo;

import Repositorios.Servicio;

public class Hotel extends Servicio {

    private String nombre_hotel;

    public Hotel(double valor, String nombre_hotel) {
        super("Hotel", valor);
        this.nombre_hotel = nombre_hotel;
    }

    public String getNombre_hotel() {
        return nombre_hotel;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre_hotel='" + nombre_hotel + '\'' +
                '}';
    }
}
