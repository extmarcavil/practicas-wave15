public class SocorristaMoto extends Socorrista {
    @Override
    public void scorrer(Vehiculo moto) {
        System.out.println("Socorriendo moto"+moto.getPatente());

    }
}
