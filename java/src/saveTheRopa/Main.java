package saveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda p1 = new Prenda("Adidas","Buzo");
        Prenda p2 = new Prenda("Nike","Remera");

        ArrayList<Prenda> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        System.out.println("Nro de Ticket generado: " + guardaRopa.guardarPrendas(lista));

        p1 = new Prenda("Reebook","Buzo");
        p2 = new Prenda("Topper","Remera");
        lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        System.out.println("Nro de Ticket generado: " + guardaRopa.guardarPrendas(lista));

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas =  guardaRopa.devolverPrendas(0);
        if(prendasDevueltas == null){
            System.out.println("No se encontraron prendas con ese ticket");
            return;
        }
        System.out.println("Prendas devueltas");
        prendasDevueltas.forEach(System.out::println);


    }
}
