public class SocorristaAuto implements SocorrerVehiculo<Auto>{

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto: " + auto.getPatente());
    }
}
