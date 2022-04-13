package com.dakar;

import com.dakar.model.Carrera;
import com.dakar.model.SocorristaAuto;
import com.dakar.model.SocorristaMoto;

public class Main {
    public static void main(String[] args) {
        Carrera carreraAutos = new Carrera(50,3000,"Carrera1",5,new SocorristaMoto(),new SocorristaAuto());

        carreraAutos.darDeAltaAuto(50,10,45,"ER324");
        carreraAutos.darDeAltaAuto(50,15,30,"43RT4");
        carreraAutos.darDeAltaAuto(50,30,40,"EMB70");
        carreraAutos.darDeAltaAuto(50,45,60,"57U6I");
        carreraAutos.darDeAltaAuto(50,50,70,"EMB71");
        //Excede el maximo permitido
        carreraAutos.darDeAltaAuto(50,50,70,"456YT");

        //Elimina participante
        carreraAutos.eliminarVehiculoConPatente("EMB71");

        //Socorriendo auto
        carreraAutos.socorrerAuto("ER324");

        System.out.println("GANADOR carreraAutos: ");
        System.out.println(carreraAutos.ganador().toString());

        Carrera carreraMotos = new Carrera(50,3000,"Carrera1",2,new SocorristaMoto(),new SocorristaAuto());

        carreraMotos.darDeAltaMoto(30,20,2,"moto1");
        carreraMotos.darDeAltaMoto(30,20,3,"moto2");

        System.out.println("GANADOR carreraMotos ");
        System.out.println(carreraMotos.ganador().toString());
    }
}
