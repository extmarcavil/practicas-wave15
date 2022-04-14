import model.GuardaRopa;
import model.Prenda;

import java.security.Guard;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Adidas", "Deportivo");
        Prenda prenda2 = new Prenda("Nike", "Deportivo 2");

        List<Prenda> prendas = List.of(prenda1, prenda2);

        Integer nroGuardaRopa = guardaRopa.guardarPrendas(prendas);

        System.out.println("Codigo asignado: " + nroGuardaRopa);

        Integer nroGuardaRopa2 = guardaRopa.guardarPrendas(prendas);

        System.out.println("Codigo asignado: " + nroGuardaRopa2);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(nroGuardaRopa);
        if(prendasDevueltas != null){
            System.out.println(prendasDevueltas);
        } else {
            System.out.println("No hay prendas guardadas con el codigo: " + nroGuardaRopa);
        }

    }
}
