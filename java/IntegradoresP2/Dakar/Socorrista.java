package IntegradoresP2.Dakar;

public class Socorrista<T extends Vehiculo> {
    public void socorrer(T vehiculo){
        if (vehiculo instanceof Auto){
            System.out.println("!! Socorriendo auto con patente " + vehiculo.getPatente() + "!!");
        } else {
            System.out.println("!! Socorriendo moto con patente: " + vehiculo.getPatente() + "!!");
        }
    };
}
