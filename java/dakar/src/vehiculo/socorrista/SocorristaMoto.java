package vehiculo.socorrista;

import vehiculo.Auto;
import vehiculo.Moto;
import vehiculo.Vehiculo;

public class SocorristaMoto extends Vehiculo {
    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo una moto - Patente: " + unaMoto.getPatente());
    }
}
