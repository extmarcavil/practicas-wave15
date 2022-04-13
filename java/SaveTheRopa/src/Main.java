import models.GuardaRopa;
import models.Prenda;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda p1 = new Prenda("Airborn", "Remera");
        Prenda p2 = new Prenda("Airborn", "Jean");

        Integer id = guardaRopa.guardarPrendas(Arrays.asList(p1, p2));

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(id);

        guardaRopa.mostrarPrendas();
    }
}
