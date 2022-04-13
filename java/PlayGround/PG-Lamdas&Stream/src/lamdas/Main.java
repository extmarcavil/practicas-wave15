package lamdas;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();
        listaDeVehiculos.add(new Vehiculo("Ford","Fiesta",1000      ));
        listaDeVehiculos.add(new Vehiculo("Ford","Focus",1200       ));
        listaDeVehiculos.add(new Vehiculo("Ford","Explorer",2500    ));
        listaDeVehiculos.add(new Vehiculo("Fiat","Uno",500          ));
        listaDeVehiculos.add(new Vehiculo("Fiat","Cronos",1000      ));
        listaDeVehiculos.add(new Vehiculo("Fiat","Torino",1250      ));
        listaDeVehiculos.add(new Vehiculo("Chevrolet","Aveo",1250   ));
        listaDeVehiculos.add(new Vehiculo("Chevrolet","Spin",2500   ));
        listaDeVehiculos.add(new Vehiculo("Toyota","Corola",1200    ));
        listaDeVehiculos.add(new Vehiculo("Toyota","Fortuner",3000  ));
        listaDeVehiculos.add(new Vehiculo("Renault","Logan",950     ));

        listaDeVehiculos.sort((Vehiculo v1,Vehiculo v2)->v1.getCosto().compareTo(v2.getCosto()));
        listaDeVehiculos.forEach(System.out::println);






    }





}
