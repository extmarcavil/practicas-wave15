package ejercicio2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {

        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        Producto pp1 = new Perecedero("leche", 11,1);
        Producto pp2 = new Perecedero("manzana", 22,4);
        Producto pp3 = new Perecedero("carne",33,2);
        Producto pp4 = new Perecedero("naranja",44,3);
        Producto pp5 = new Perecedero("lechuga", 55, 2);
        Producto pnp1 = new NoPerecedero("arroz yamani", 70, "arroces");
        Producto pnp2 = new NoPerecedero("lentejas", 78, "legumbres");
        Producto pnp3= new NoPerecedero("garbanzos", 55, "legumbres");
        Producto pnp4 = new NoPerecedero("fideos codito", 80, "pastas");
        Producto pnp5 = new NoPerecedero("fideos moño", 85, "pastas");

        listaProductos.add(pp1);
        listaProductos.add(pp2);
        listaProductos.add(pp3);
        listaProductos.add(pp4);
        listaProductos.add(pp5);
        listaProductos.add(pnp1);
        listaProductos.add(pnp2);
        listaProductos.add(pnp3);
        listaProductos.add(pnp4);
        listaProductos.add(pnp5);

        double total = 0; //2.75 22 11 22 18,33

        for (Producto p : listaProductos){
            total += p.calcular(1);
        }

        System.out.println("El total de la compra es: $" + total);





    }
}
