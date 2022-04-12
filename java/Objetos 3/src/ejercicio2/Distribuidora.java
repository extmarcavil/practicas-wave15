package ejercicio2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();

        Producto pp1 = new Perecedero("leche", 12,1);
        Producto pp2 = new Perecedero("manzana", 22,4);
        Producto pp3 = new Perecedero("carne",33,2);
        Producto pp4 = new Perecedero("naranja",44,3);
        Producto pp5 = new Perecedero("milanesa", 55, 1);
        Producto pnp1 = new NoPerecedero("arroz", 22, "arroz");
        Producto pnp2 = new NoPerecedero("fideos", 300, "fideos");
        Producto pnp3= new NoPerecedero("picadillo", 205, "enlatado");
        Producto pnp4 = new NoPerecedero("atun", 200, "enlatado" );
        Producto pnp5 = new NoPerecedero("aceite", 400, "aceite");

        productos.add(pp1);
        productos.add(pp2);
        productos.add(pp3);
        productos.add(pp4);
        productos.add(pp5);
        productos.add(pnp1);
        productos.add(pnp2);
        productos.add(pnp3);
        productos.add(pnp4);
        productos.add(pnp5);

        double precioLeche = pp1.calcular(5);
        System.out.println("El precio de la leche es: " + precioLeche);

    }
}
