package vehiculo.socorrista;

import vehiculo.Auto;
import vehiculo.Vehiculo;

public class SocorristaAuto extends Vehiculo {
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo un auto - Patente: " + unAuto.getPatente());
    }
}
