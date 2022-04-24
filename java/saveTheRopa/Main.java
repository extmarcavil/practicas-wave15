package saveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda remera = new Prenda("Demencial", "Remera");
        Prenda pantalon = new Prenda("QuickSilver", "Pantalon");
        Prenda campera = new Prenda("Devre", "Campera");
        List<Prenda> nuevoListado = new ArrayList<Prenda>();
        nuevoListado.add(remera);
        nuevoListado.add(pantalon);
        nuevoListado.add(campera);
        List<Prenda> nuevoListadoDos = new ArrayList<Prenda>();
        nuevoListadoDos.add(remera);
        nuevoListadoDos.add(campera);
        List<Prenda> nuevoListadoTres = new ArrayList<Prenda>();
        nuevoListadoTres.add(campera);

        GuardaRopa primerGuardarropa = new GuardaRopa(1);

        System.out.println(primerGuardarropa.guardarPrendas(nuevoListado));
        System.out.println(primerGuardarropa.guardarPrendas(nuevoListadoDos));
        System.out.println(primerGuardarropa.guardarPrendas(nuevoListadoTres));
        primerGuardarropa.devolverPrendas(2);
        primerGuardarropa.devolverPrendas(1);
    }
}
