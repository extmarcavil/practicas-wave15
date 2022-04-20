package Ejercicio2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Distribuidora {

    public static void main(String[] args) {
        Perecedero carne = new Perecedero("carne", 1000, 1);
        Perecedero pollo = new Perecedero("pollo", 500, 3);
        Perecedero pescado = new Perecedero("pescado", 650, 2);
        Perecedero manzana = new Perecedero("manzana", 40, 5);
        Perecedero jamon = new Perecedero("jamon", 300, 2);
        NoPerecedero atun = new NoPerecedero("atun", 200, "lata");
        NoPerecedero arroz = new NoPerecedero("arroz", 60, "grano");
        NoPerecedero garbanzo = new NoPerecedero("garbanzo", 100, "grano");
        NoPerecedero fideos = new NoPerecedero("fideos", 100, "pasta");
        NoPerecedero sopa = new NoPerecedero("sopa", 55, "polvo");

        ArrayList<Producto> arrayProductos = new ArrayList<>();
        Collections.addAll(arrayProductos, carne, pollo, pescado, manzana, jamon, atun, arroz, garbanzo, fideos, sopa);

        //Llevo dos unidades de cada producto
        for(int i = 0; i < arrayProductos.size(); i++){
            Producto paraDevolverPrecio = arrayProductos.get(i);
            System.out.println("El precio de " + paraDevolverPrecio.getNombre() + " es: $" + paraDevolverPrecio.calcular(2));
        }

    }

}
