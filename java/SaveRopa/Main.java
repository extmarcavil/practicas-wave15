package SaveRopa;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Zapatillas");
        Prenda prenda2 = new Prenda("Nike", "Remera");

        Integer codigo = guardaRopa.guardarPrendas(List.of(prenda1, prenda2));

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigo);

        System.out.println("Prendas devueltas");
        for (Prenda prenda : prendasDevueltas) {
            System.out.print(prenda.getMarca() + " " + prenda.getModelo());
        }

    }
}
