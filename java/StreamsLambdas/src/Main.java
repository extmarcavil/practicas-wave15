import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList();
        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));

        Garaje garaje = new Garaje(1, listaVehiculos);
        listaVehiculos.sort((Vehiculo v1, Vehiculo v2) -> v1.getCosto().compareTo(v2.getCosto()));
        listaVehiculos.forEach(System.out::println);



     }
}
