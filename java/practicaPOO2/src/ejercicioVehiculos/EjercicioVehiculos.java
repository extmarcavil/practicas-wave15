package ejercicioVehiculos;

/*Ejercicio 1
Inicia creando una clase Vehículo con los atributos modelo, marca y costo.
Luego crea una clase garaje con los atributos id o identificador único y una lista de vehículos.
Crea además los constructores de las clases y los métodos Setter y Getter.*/

/*Ejercicio 2
Haz una clase Main con el método main para representar un escenario donde se crea una instancia de la clase garaje
con una lista de vehículos según la tabla.*/

/*Ejercicio 3
Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una lista de vehículos ordenados
por precio de menor a mayor, imprime por pantalla el resultado.*/

/*Ejercicio 4
De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.*/

/*Ejercicio 5
Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000
y por último, obtén el promedio total de precios de toda la lista de vehículos.*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.OptionalDouble;

public class EjercicioVehiculos {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Fiat", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garaje garaje = new Garaje(1, vehiculos);

        //Lista ordenada por precio de menor a mayor
        System.out.println("Lista ordenada por precio de menor a mayor:");
    //        garaje.getVehiculos().stream()
    //            .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
//            .forEach(System.out::println);
        garaje.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        garaje.getVehiculos().stream().forEach(System.out::println);

        System.out.println();

        //Lista ordenada por marca y precio
        System.out.println("Lista ordenada por marca y precio:");
//        garaje.getVehiculos().stream()
//                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
//                .sorted((x,y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
//                .forEach(System.out::println);
        garaje.getVehiculos()
                .sort(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto));
        garaje.getVehiculos().stream().forEach(System.out::println);

        System.out.println();

        //Lista con precio no mayor a 1000
        System.out.println("Lista con precio no mayor a 1000:");
        garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() <= 1000)
                .forEach(System.out::println);

        System.out.println();

        //Lista con precios mayor o igual a 1000
        System.out.println("Lista con precios mayor o igual a 1000:");
        garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println();

        //Promedio total de precios de toda la lista de vehículos
        System.out.println("Promedio total de precios de toda la lista de vehículos:");
        double promedio = garaje.getVehiculos().stream()
                .mapToDouble(x -> x.getCosto()).average().getAsDouble();
        System.out.println(promedio);
    }
}
