package saveTheRopaSA;

import saveTheRopaSA.model.GuardaRopa;
import saveTheRopaSA.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("LEVIS", "REMERA"));
        prendas.add(new Prenda("LEVIS", "JEAN"));

        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas(prendas);

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigo);

        guardaRopa.mostrarPrendas();
    }
}
