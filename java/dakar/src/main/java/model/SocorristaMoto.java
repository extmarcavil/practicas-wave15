package model;

public class SocorristaMoto extends Socorrista<Moto> {

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto "+vehiculo.getPatente());
    }
}
