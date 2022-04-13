package automotora;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo fiesta = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo focus = new Vehiculo("Focus","Ford",1200);
        Vehiculo explorer = new Vehiculo("Explorer","Ford",2500);
        Vehiculo uno = new Vehiculo("Uno","Fiat",500);
        Vehiculo chronos = new Vehiculo("Chronos","Fiat",1000);
        Vehiculo torino = new Vehiculo("Torino","Fiat",1250);
        Vehiculo aveo = new Vehiculo("Aveo","Chevrolet",1250);
        Vehiculo spin = new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo corolla = new Vehiculo("Corolla","Toyota",1200);
        Vehiculo fortuner = new Vehiculo("Fortuner","Toyota",3000);
        Vehiculo logan = new Vehiculo("Logan","Renault",2500);
        List<Vehiculo> listado = new ArrayList<>(){{
            add(fiesta);add(focus);add(explorer);add(uno);
            add(chronos);add(torino);add(aveo);add(spin);
            add();
        }};

        Garage garage = new Garage(1,listado);
        Comparator<Vehiculo> sortByPrice = Comparator.comparing(Vehiculo::getCosto);

        for (Vehiculo v: garage.getListado()){
            System.out.println(v.toString());
        }
    }
}
