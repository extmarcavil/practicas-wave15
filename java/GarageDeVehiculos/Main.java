package GarageDeVehiculos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static Object Vehiculo;

    public static void main(String[] args) {
        GarageDeVehiculos.Vehiculo Fiesta = new Vehiculo("Fiesta", "Modelo1", 1000);
        Vehiculo Uno = new Vehiculo("Uno", "Modelo2", 750);
        Vehiculo Toyota = new Vehiculo("Toyota", "Modelo3", 500);
        Vehiculo AlfaRomeo = new Vehiculo("Alfa Romeo", "Modelo 4", 850);
        Vehiculo Fiesta2 = new Vehiculo("Fiesta", "Modelo 2", 950);

        Garage garage =  new Garage(1);

        garage.AgregarVehiculo(Fiesta);
        garage.AgregarVehiculo(Uno);
        garage.AgregarVehiculo(Toyota);
        garage.AgregarVehiculo(AlfaRomeo);
        garage.AgregarVehiculo(Fiesta2);

        // System.out.println(garage.toString());

        List<Vehiculo> lista = garage.getVehiculos();

        /*lista.stream().sorted((x, y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);*/


        System.out.println(lista);
        Collections.sort(lista, (o1, o2) -> o1.getCosto().compareTo(o2.getCosto()));
        System.out.println(lista);

        /*Collections.sort(lista, Comparator.comparing(Vehiculo::getCosto).
                thenComparing(Vehiculo::getMarca));*/

        Collections.sort(lista, new Comparator() {

            public int compare(Object o1, Object o2) {

                String x1 = ((Vehiculo) o1).getModelo();
                String x2 = ((Vehiculo) o2).getModelo();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                } else {
                    Integer x3 = ((Vehiculo) o1).getCosto();
                    Integer x4 = ((Vehiculo) o2).getCosto();
                    return x3.compareTo(x4);
                }
            }});

        System.out.println(lista);
        // System.out.println(lista.get(0).getCosto());
    }
}
