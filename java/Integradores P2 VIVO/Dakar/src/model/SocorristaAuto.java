package model;

public class SocorristaAuto implements Socorrista{

    @Override
    public void socorrer(Vehiculo unVehiculo) {
        String patente = unVehiculo.getPatente();
        System.out.println("Socorriendo el auto: " + patente);
    }
}
