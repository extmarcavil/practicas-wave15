import models.Flota;
import models.NaveSimple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Asteroid asteroid = new Asteroid();

        NaveSimple n1 = new NaveSimple("Battlestar Galactica", 1f, 2f);
        NaveSimple n2 = new NaveSimple("Battlestar Pegasus", 5f, 8f);

        Flota flota = new Flota();
        flota.addNave(n1);
        flota.addNave(n2);

        NaveSimple n3 = new NaveSimple("USS Enterprice", 10f, 1231f);

        asteroid.addJugador(flota);
        asteroid.addJugador(n3);

        List<List<Float>> coords = new ArrayList<>();
        coords.add(Arrays.asList(5f, 3f));
        coords.add(Arrays.asList(1f, 999f));
        coords.add(Arrays.asList(5f, 2f));

        asteroid.iniciarJuego(coords);
    }
}
