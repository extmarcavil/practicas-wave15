package com.muchut.agenciadeturismo;

public class Reserva {
    public int reservaDeHotel(int i){
        int precio = 500;
        return i * precio;
    }
    public int reservaDeComida(int i){
        int precio = 50;
        return i * precio;
    }
    public int reservaDeBoletosViaje(int i){
        int precio = 300;
        return i * precio;
    }
    public int reservaDeTransporte(int i){
        int precio = 120;
        return i * precio;
    }


}
