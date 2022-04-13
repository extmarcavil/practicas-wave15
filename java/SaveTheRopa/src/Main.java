import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Nike", "zapatillas");
        Prenda prenda2 = new Prenda("Addidas", "remera");

        GuardaRopa guardaRopa = new GuardaRopa();

        int ticket = guardaRopa.guardarPrendas(List.of(prenda1, prenda2));

        guardaRopa.mostrarPrendas();

        System.out.println("Las prendas obtenidas son: " + guardaRopa.devolverPrendas(ticket));


    }
}
