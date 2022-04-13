public class SocorristaAuto extends Socorrista{

    @Override
    public void scorrer(Vehiculo auto) {
        System.out.println("Socorriendo auto"+auto.getPatente());
    }
}
