import modelo.GuardaRopa;
import modelo.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Adidas", "1");
        Prenda prenda2 = new Prenda("Puma", "1");
        Prenda prenda3 = new Prenda("Adidas", "2");
        Prenda prenda4 = new Prenda("Adidas", "3");

        List<Prenda> prendas = new ArrayList<Prenda>();
        List<Prenda> prendas1 = new ArrayList<Prenda>();

        prendas.add(prenda1);
        prendas.add(prenda2);

        prendas1.add(prenda4);

        GuardaRopa gr = new GuardaRopa();

        System.out.println("Guardar prendas y Mostrar prendas");
        Integer clave = gr.guardarPrendas(prendas);
        System.out.println(clave);
        gr.mostrarPrendas();

        Integer clave2 = gr.guardarPrendas(prendas1);
        System.out.println(clave2);
        gr.mostrarPrendas();

        System.out.println("Devolver prendas: ");
        System.out.println(gr.devolverPrendas(clave));
        System.out.println(gr.devolverPrendas(clave2));

    }
}
