package IntegradoresP2.SaveTheRopa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Save The Ropa");
        System.out.println("-------------");

        // Instanciar guardaropa.
        GuardaRopa guardaRopa = new GuardaRopa();

        // Crear prendas.
        Prenda prenda1 = new Prenda("marca1", "modelo1");
        Prenda prenda2 = new Prenda("marca2", "modelo2");
        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);

        System.out.println("--El usuario guarda 2 prendas...");
        guardaRopa.guardarPrendas(prendas);
        System.out.println("--Se muestra el contenido del guardaropas...");
        guardaRopa.mostrarPrendas();
        System.out.println("--El usuario retira sus prendas...");
        guardaRopa.devolverPrendas(1);
        System.out.println("--Se muestra el contenido del guardaropas...");
        guardaRopa.mostrarPrendas();
    }
}
