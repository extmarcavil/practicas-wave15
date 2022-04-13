package SaveTheRopa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Nike","zapatillas");
        Prenda prenda2 = new Prenda("Nike","campera");
        ArrayList<Prenda> listadoPrendas = new ArrayList<>();
        listadoPrendas.add(prenda1);
        listadoPrendas.add(prenda2);

        Prenda prenda3 = new Prenda("Adidas","pantalon");
        Prenda prenda4 = new Prenda("Adidas","medias");
        ArrayList<Prenda> listadoPrendas2 = new ArrayList<>();
        listadoPrendas2.add(prenda3);
        listadoPrendas2.add(prenda4);

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigoPrenda=guardaRopa.guardarPrendas(listadoPrendas);
        Integer codigoPrenda2=guardaRopa.guardarPrendas(listadoPrendas2);

        System.out.println("La prenda corresponde al codigo:"+codigoPrenda2);
        System.out.println("------------------------------");
        System.out.println("Listado de prendas correspondientes al codigo:");
        guardaRopa.devolverPrendas(codigoPrenda2).forEach(System.out::println);
        System.out.println("------------------------------");
        System.out.println("Listado de prendas:");
        guardaRopa.mostrarPrendas();
    }
}
