public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo v5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo v7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo v8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo v9 = new Vehiculo("Logan", "Renault", 950);

        Garaje garaje = new Garaje(1l);

        garaje.addVehiculo(v1);
        garaje.addVehiculo(v2);
        garaje.addVehiculo(v3);
        garaje.addVehiculo(v4);
        garaje.addVehiculo(v5);
        garaje.addVehiculo(v6);
        garaje.addVehiculo(v7);
        garaje.addVehiculo(v8);
        garaje.addVehiculo(v9);

        System.out.println("###");
        System.out.println("### Vehiculos Ordenados Por Precio:");
        System.out.println("###");

        garaje.getVehiculosPorPrecioMenorAMayor().forEach(v -> System.out.println(v.toString()));

        System.out.println("###");
        System.out.println("### Vehiculos Ordenados Por Marca Y Precio:");
        System.out.println("###");

        garaje.getVehiculosPorMarcaYPorPrecio().forEach(v -> System.out.println(v.toString()));

        System.out.println("###");
        System.out.println("### Vehiculos Con Precio Menor a 1000:");
        System.out.println("###");

        garaje.getVehiculosConPrecioMenorA1000().forEach(v -> System.out.println(v.toString()));

        System.out.println("###");
        System.out.println("### Vehiculos Con Precio Mayor o Igual a 1000:");
        System.out.println("###");

        garaje.getVehiculosConPrecioMayorOIgualA1000().forEach(v -> System.out.println(v.toString()));

        System.out.println("###");
        System.out.println("### Precio Promedio:");
        System.out.println("###");

        System.out.println(garaje.getPrecioPromedio());
    }
}
