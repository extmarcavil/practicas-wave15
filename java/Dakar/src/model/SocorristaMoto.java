package model;

public class SocorristaMoto implements Socorrista{
    @Override
    public void socorrer(Vehiculo unVehiculo) {
        String patente = unVehiculo.getPatente();
        System.out.println("Socorriendo la moto: " + patente);
    }
}
