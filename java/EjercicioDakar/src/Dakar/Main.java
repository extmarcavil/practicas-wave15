package Dakar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Auto auto1 = new Auto(220,200,20,"MRA414",1000,4);
        Auto auto2 = new Auto(120,100,20,"WHN404",1000,4);
        Auto auto3 = new Auto(300,250,40,"JWN023",1000,4);
        Auto auto4 = new Auto(230,100,20,"SJQ123",1000,4);
        Moto moto1 = new Moto(300,150,350,"KSA921",300,2);

        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(auto1);
        listaVehiculos.add(auto2);
        listaVehiculos.add(auto3);
        listaVehiculos.add(auto4);
        listaVehiculos.add(moto1);

        Carrera carrera = new Carrera(1500,1800.21,"DAKAR",4,listaVehiculos);

        var patenteGanadora = carrera.vehiculoGanador();

        System.out.println("LOS COMPETIDORES SON: \n");

        for (Vehiculo c : listaVehiculos){
            System.out.println(c);
        }

        carrera.socorrerAuto("WHN504");
        carrera.socorrerMoto("KSA921");

        System.out.println("EL GANADOR DE LA CARRERA FUE EL AUTO CON PATENTE: " + patenteGanadora);

    }
}
