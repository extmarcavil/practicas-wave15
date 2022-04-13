package ejercicio2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();

        Producto pp1 = new Perecedero("leche", 11,1);
        Producto pp2 = new Perecedero("manzana", 22,4);
        Producto pp3 = new Perecedero("carne",33,2);
        Producto pp4 = new Perecedero("naranja",44,3);
        Producto pp5 = new Perecedero("huevos",50,5);
        Producto pnp1 = new NoPerecedero("atun",5,"pescado");
        Producto pnp2 = new NoPerecedero("manzana",40,"frutas");
        Producto pnp3= new NoPerecedero("pera",45,"fruta");
        Producto pnp4 = new NoPerecedero("manteca",120,"lacteos");
        Producto pnp5 = new NoPerecedero("queso fresco",250,"lacteos");

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


        double precioFinal = 0;
        for(Producto p : productos){
            System.out.println("Agrego 5 " + p);
            precioFinal += p.calcular((int) productos.stream().count());
        }

        System.out.println("Precio total de la venta: " + precioFinal);

    }
}
