package carrera;

import modelos.Socorrista;
import modelos.Vehiculo;

public class SocorristaAuto implements Socorrista {

    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo al auto: ");
        System.out.println(vehiculo.getPatente());
    }
}
