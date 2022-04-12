import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var listaGaraje = new ArrayList<Garaje>();

        var listaVehiculos = new ArrayList<Vehiculo>();

        listaVehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        listaVehiculos.add(new Vehiculo("Focus","Ford",1200));
        listaVehiculos.add(new Vehiculo("Explorer","Ford",2500));
        listaVehiculos.add(new Vehiculo("Uno","Fiat",500));
        listaVehiculos.add(new Vehiculo("Cronos","Fiat",1000));
        listaVehiculos.add(new Vehiculo("Torino","Fiat",1250));
        listaVehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        listaVehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        listaVehiculos.add(new Vehiculo("Corola","Toyota",1200));
        listaVehiculos.add(new Vehiculo("Fortuner","Toyota",3000));
        listaVehiculos.add(new Vehiculo("Logan","Renault",950));

        listaGaraje.add(new Garaje(listaVehiculos));

        listaVehiculos.sort((o1, o2) -> o1.getCosto()-(o2.getCosto()));

        System.out.println("+++++++ Ejercicio 3 +++++++++++");

        listaVehiculos.forEach(item -> {
            System.out.println("La marca es " + item.getMarca()  +
                    ", modelo " + item.getModelo() +
                    ", costo " + item.getCosto());
        });

        System.out.println("+++++++ Ejercicio 4 +++++++++++");


        var listMarca = listaVehiculos.stream().sorted((o1, o2) -> o1.getMarca().compareTo(o2.getMarca()));

        listMarca.forEach(item -> {
            System.out.println("La marca es " + item.getMarca()  +
                    ", modelo " + item.getModelo() +
                    ", costo " + item.getCosto());
        });

        System.out.println("+++++++ Ejercicio 5 +++++++++++");
        var listMenorMil = listaVehiculos.stream().filter(f -> f.getCosto() < 1000);
        var listMayorIgualMil = listaVehiculos.stream().filter(f -> f.getCosto() >= 1000);

        System.out.println("+++++++ Vehiculos con costo menor a 1000 +++++++++++");
        listMenorMil.forEach(item -> {
            System.out.println("La marca es " + item.getMarca()  +
                    ", modelo " + item.getModelo() +
                    ", costo " + item.getCosto());
        });
        System.out.println("+++++++ Vehiculos con costo mayor o igual a 1000 +++++++++++");
        listMayorIgualMil.forEach(item -> {
            System.out.println("La marca es " + item.getMarca()  +
                    ", modelo " + item.getModelo() +
                    ", costo " + item.getCosto());
        });
        var listTotalPrecio = listaVehiculos.stream().map(m -> m.getCosto());
        var total = listTotalPrecio.reduce(0, (a, b) -> a + b);
        var promedio = total / listaVehiculos.stream().count();
        System.out.println("El promedio de costos es " + promedio);

    }
}
