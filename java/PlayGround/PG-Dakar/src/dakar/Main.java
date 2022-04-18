package dakar;

import model.Auto;
import model.AutoSocorrista;

public class Main {

    public static void main(String[] args) {
        CarreraDeVehiculos carreraPiston = new CarreraDeVehiculos(1000.0, 1500, "Piston", 5);
        Auto renaultClio = new Auto(120D,20D,19D,"FTN646");
        Auto ferrari = new Auto(300D,50D,19D,"AB134A");
        AutoSocorrista sosAuto = new AutoSocorrista();
        carreraPiston.darDeAltaAuto(renaultClio);
        carreraPiston.darDeAltaAuto(ferrari);
        sosAuto.socorrer(renaultClio);
        carreraPiston.iniciarCarrera();

        System.out.println("El ganador tiene patente " + carreraPiston.definirGanador().getPatente() );






    }
}
