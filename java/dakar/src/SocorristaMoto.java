public class SocorristaMoto extends Socorrista {
    @Override
    public void socorrer(Vehiculo moto) {
        System.out.println("Socorriendo moto "+moto.getPatente());
    }
}
