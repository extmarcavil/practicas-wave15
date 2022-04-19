public class SocorristaAuto extends Socorrista{

    @Override
    public void socorrer(Vehiculo auto) {
        System.out.println("Socorriendo auto "+auto.getPatente());
    }
}
