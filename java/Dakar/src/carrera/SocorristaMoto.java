package carrera;

import modelos.Socorrista;
import modelos.Vehiculo;

public class SocorristaMoto implements Socorrista {

    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo a la moto: ");
        System.out.println(vehiculo.getPatente());
    }
}
