package SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Prenda> listaPrendas = new ArrayList<Prenda>();

        Prenda prenda1 = new Prenda("Nike","CR7");
        Prenda prenda2 = new Prenda("Adidas","Messi");
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);

        GuardaRopa guardaRopa1 = new GuardaRopa();
        var codigo = guardaRopa1.guardarPrendas(listaPrendas);

        guardaRopa1.mostrarPrendas();
        guardaRopa1.devolverPrendas(codigo);
        System.out.println("Se devuelven las prendas del codigo " + codigo);
        guardaRopa1.mostrarPrendas();
    }
}
