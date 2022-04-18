package Dakar;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Carrera carreraAutos = new Carrera(450.7,1500.8,"Carrera1",4);

        carreraAutos.darDeAltaAuto(35.0,2.0,45.0,"AB23CD");
        carreraAutos.darDeAltaAuto(45.0,7.0,45.0,"AJ13CD");
        carreraAutos.darDeAltaAuto(65.0,3.0,65.0,"LB73GL");
        carreraAutos.darDeAltaAuto(25.0,8.0,75.0,"YT63CJ");
        //carreraAutos.darDeAltaAuto(75.0,1.5,35.0,"AB23CF");

        carreraAutos.definirGanador();

        System.out.println("ahora eliminamos un vehiculo");

        carreraAutos.eliminarVehiculoPorPatente("LB73GL");

        carreraAutos.definirGanador();

        carreraAutos.socorrerAuto("AB23CD");
    }
}
