package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List lista = new ArrayList<>();

        Perecedero mango = new Perecedero("mango", 12.5 );
        Perecedero leche = new Perecedero("leche", 10.2 );
        NoPerecedero galletas = new NoPerecedero("galletas", 20 );
        lista.add(mango);
        lista.add(leche);
        lista.add(galletas);

        System.out.println(lista);
    }
}
